package guava;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaRateLimiterRunCallable {
    public static final RateLimiter RATE_LIMITER = RateLimiter.create(1.0);  // 1 per second

    static class RateLimiterCallable<T> implements Callable<T> {
        @Override
        public T call() throws Exception {
            // this will trigger RuntimeException, increase timeout to 1000 to avoid it
            boolean permitAcquired =
                    GuavaRateLimiterRunCallable.RATE_LIMITER.tryAcquire(1, 1, TimeUnit.MILLISECONDS);
            if (permitAcquired) {
                log.info("do something");
                return null;
            } else {
                throw new RuntimeException("permit was not granted by rateLimiter");
            }
        }
    }

    public void test() throws Exception {
        RateLimiterCallable<String> callable = new RateLimiterCallable<>();
        callable.call();
        callable.call();
        callable.call();
        callable.call();
    }

    public static void main(String[] args) throws Exception {
        GuavaRateLimiterRunCallable guavaRateLimiterRunCallable = new GuavaRateLimiterRunCallable();
        guavaRateLimiterRunCallable.test();
    }

}
