package concurrent;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrentFuture {

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            TimeUnit.SECONDS.sleep(10);
            return 100;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Task t = new Task();
        Future<Integer> future = executorService.submit(t);
        executorService.shutdown();

        log.info("now waiting result");
        log.info("" + future.get());
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
