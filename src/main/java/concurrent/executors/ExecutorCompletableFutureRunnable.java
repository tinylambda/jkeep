package concurrent.executors;

import java.sql.SQLSyntaxErrorException;
import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorCompletableFutureRunnable {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        CompletableFuture completableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("in run");
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println("sleep interrupted");
                }
                System.out.println("end run");
            }
        }, executorService);

//        System.out.println(completableFuture.get());
//        executorService.shutdownNow(); // will output "sleep interrupted"

        executorService.shutdown();  // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
        System.out.println("wait 5 seconds");
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("try to get result");
        System.out.println("now block on get() method~");
        System.out.println(completableFuture.get());
    }
}
