package concurrent;

import java.util.Comparator;
import java.util.Objects;
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
public class ConcurrentThreadPool {

    @Slf4j
    static class SampleTask implements Callable<Boolean> {
        private int priority;
        private int id;

        public SampleTask(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public Boolean call() throws Exception {
            log.info("I am a callable with priority: " + getPriority());
            TimeUnit.SECONDS.sleep(getPriority() / 10);
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SampleTask that = (SampleTask) o;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    @Slf4j
    static class MyRunnableFuture<T> implements RunnableFuture<T> {

        @Override
        public void run() {

        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public T get() throws InterruptedException, ExecutionException {
            return null;
        }

        @Override
        public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 2;
        int qInitialSize = 2;

        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue<>(qInitialSize, new Comparator<Runnable>() {
            @Override
            public int compare(Runnable o1, Runnable o2) {
                return -1;
            }
        });

        ExecutorService executorService = new ThreadPoolExecutor(
                nThreads,
                nThreads,
                0, TimeUnit.MILLISECONDS,
                priorityBlockingQueue
        );

        SampleTask sampleTask1 = new SampleTask(1, 88);
        SampleTask sampleTask2 = new SampleTask(2, 77);
        SampleTask sampleTask3 = new SampleTask(3, 47);
        SampleTask sampleTask4 = new SampleTask(4,33);
        SampleTask sampleTask5 = new SampleTask(5, 27);
        SampleTask sampleTask6 = new SampleTask(5, 22);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (!priorityBlockingQueue.isEmpty() && executorService.isShutdown()) {
                    log.error("current task in queue: " + priorityBlockingQueue.size());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        priorityBlockingQueue.clear();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("priority queue is now empty, bye.");
            }
        });

        executorService.submit(sampleTask1);
        executorService.submit(sampleTask2);
        executorService.submit(sampleTask3);
        executorService.submit(sampleTask4);
        executorService.submit(sampleTask5);
        executorService.submit(sampleTask6);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
