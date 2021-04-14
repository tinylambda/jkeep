package concurrent.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorCompletableFutureRunnable {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        CompletableFuture completableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                log.info("in run");
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    log.info("sleep interrupted");
                }
                log.info("end run");
            }
        }, executorService);

//        log.info(completableFuture.get());
//        executorService.shutdownNow(); // will output "sleep interrupted"

        executorService.shutdown();  // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
        log.info("wait 5 seconds");
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        log.info("try to get result");
        log.info("now block on get() method~");
        log.info("" + completableFuture.get());
    }
}
