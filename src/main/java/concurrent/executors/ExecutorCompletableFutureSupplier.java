package concurrent.executors;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutorCompletableFutureSupplier {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                return 100;
            } catch (Exception e) {
                log.info("exception happens");
                throw new CompletionException(e);
            }
        }, executorService);

        executorService.shutdown();

        log.info("now waiting result:");
        log.info("" + completableFuture.get());
    }
}
