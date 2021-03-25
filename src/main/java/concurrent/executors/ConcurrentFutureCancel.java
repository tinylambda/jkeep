package concurrent.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ConcurrentFutureCancel {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Future<Boolean> future = executorService.submit(new Callable<Boolean>() {
            private boolean stop = false;

            @Override
            public Boolean call() throws Exception {
                while (!stop) {
                    System.out.println("still running in call");
                    TimeUnit.SECONDS.sleep(1);
                }
                return true;
            }
        });

        System.out.println("got future: " + future);
        int sleepTime = 10;
        System.out.println("now sleep " + sleepTime + " seconds");
        TimeUnit.SECONDS.sleep(sleepTime);
        System.out.println("now cancel future");
        future.cancel(true); // change to false to test
        try {
            System.out.println(future.get());
        } catch (CancellationException e) {
            System.out.println("good! cancelling the future works");
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
