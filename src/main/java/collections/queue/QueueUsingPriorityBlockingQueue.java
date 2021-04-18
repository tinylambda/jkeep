package collections.queue;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueUsingPriorityBlockingQueue {

    static class PriorityFuture<T> implements RunnableFuture<T> {
        private RunnableFuture<T> src;
        private int priority;

        public PriorityFuture(RunnableFuture<T> other, int priority) {
            this.src = other;
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public void run() {
            src.run();
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return src.cancel(mayInterruptIfRunning);
        }

        @Override
        public boolean isCancelled() {
            return src.isCancelled();
        }

        @Override
        public boolean isDone() {
            return src.isDone();
        }

        @Override
        public T get() throws InterruptedException, ExecutionException {
            return src.get();
        }

        @Override
        public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return src.get(timeout, unit);
        }
    }

    static class PriorityFutureComparator implements Comparator<Runnable> {

        @Override
        public int compare(Runnable o1, Runnable o2) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            } else {
                int p1 = ((PriorityFuture<?>) o1).getPriority();
                int p2 = ((PriorityFuture<?>) o2).getPriority();
                return Integer.compare(p1, p2);
            }
        }
    }

    static class ExampleJob implements Callable<Long> {
        public int getPriority() {
            return priority;
        }

        private int priority;

        public ExampleJob(int priority) {
            this.priority = priority;
        }

        @Override
        public Long call() throws Exception {
            long randSecs = new Random().nextInt(10);
            log.info(
                    String.format(
                            "executing priority(%s) and will sleep for %s seconds",
                            priority, randSecs
                    )
            );
            TimeUnit.SECONDS.sleep(randSecs);
            return randSecs;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 2;
        int qInitialSize = 10;
        Random random = new Random();

        ExecutorService executorService = new ThreadPoolExecutor(
                nThreads,
                nThreads,
                0L,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>(qInitialSize, new PriorityFutureComparator())
        ) {
            @Override
            protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
                RunnableFuture<T> newTaskFor = super.newTaskFor(callable);
                return new PriorityFuture<T>(newTaskFor, ((ExampleJob) callable).getPriority());
            }
        };

        for (int i=0; i<10; i++) {
            int priority = random.nextInt(100);
            log.info("scheduling " + priority);
            ExampleJob job = new ExampleJob(priority);
            executorService.submit(job);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        log.info("done");
    }
}
