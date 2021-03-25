package concurrent.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ConcurrentFutureCancel {

    static class MyTask implements Callable<Boolean> {
        private String name;
        private boolean stopped = true;

        public MyTask(String name) {
            this.name = name;
        }

        public boolean start() {
            stopped = false;
            return true;
        }

        public boolean stop() {
            stopped = true;
            return true;
        }

        @Override
        public Boolean call() throws Exception {
            while (!stopped) {
                System.out.println("still working");
                TimeUnit.SECONDS.sleep(1);
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        MyTask myTask = new MyTask("task 1");
        boolean result = myTask.start();
        assert result;
        Future<Boolean> future = executorService.submit(myTask);

        System.out.println("wait 5 seconds and stop myTask");
        TimeUnit.SECONDS.sleep(5);
        result = myTask.stop();
        assert result;

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        // now we can safely get result from future
        result = future.get();
        System.out.println("the result of future get is: " + result);
        assert result;

        System.out.println("done!");

    }
}
