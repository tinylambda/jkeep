package concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrentFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i=0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int s = random.nextInt(10);
                    log.info(Thread.currentThread().getName() + " sleeping " + s);
                    try {
                        TimeUnit.SECONDS.sleep(s);
                    } catch (InterruptedException e) {

                    }

                }
            });
        }

        for (int i=0; i<10; i++) {
            try{
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {

            }

            log.info("put another task");
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    log.info("running 10");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {

                    }
                }
            });
        }

        try{
            executorService.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        }

        log.info("back to main");
    }
}
