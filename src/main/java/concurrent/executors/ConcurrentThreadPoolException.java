package concurrent.executors;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrentThreadPoolException {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0; i<10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int s = random.nextInt(10);
                    log.info(Thread.currentThread().getName() + " sleeping " + s);
                    try {
                        TimeUnit.SECONDS.sleep(s);
                        throw new RuntimeException("Exception");
                    } catch (Exception e) {
                        log.info("Current thread name is {}", Thread.currentThread().getName());
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        log.info("done");
    }
}
