package guava;


import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaRateLimiter {
    static void doSomeLimitedOperation(int n) throws InterruptedException {
        log.info("do something {}", n);
        TimeUnit.SECONDS.sleep(n);
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(2);
        long startTime = ZonedDateTime.now().getSecond();
        rateLimiter.acquire(1);
        doSomeLimitedOperation(0);
        rateLimiter.acquire(1);
        doSomeLimitedOperation(0);
        rateLimiter.acquire(1);
        doSomeLimitedOperation(0);
        rateLimiter.acquire(1);
        doSomeLimitedOperation(0);
        rateLimiter.acquire(1);
        doSomeLimitedOperation(0);
        rateLimiter.acquire(1);
        doSomeLimitedOperation(0);

        long elapsedTimeSeconds = ZonedDateTime.now().getSecond() - startTime;
        log.info("elapsed {}", elapsedTimeSeconds);
    }
}
