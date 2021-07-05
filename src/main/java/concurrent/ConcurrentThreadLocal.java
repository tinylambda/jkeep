package concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrentThreadLocal {
    static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int r = random.nextInt(1000);
        log.info("main thread set to {}", r);
        integerThreadLocal.set(r);
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i=0; i<10; i++) {
            executorService.submit(() -> {
                log.info("integerThreadLocal is {}", integerThreadLocal.get());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
