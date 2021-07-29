package guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaCache {
    private static final LoadingCache<String, Object> LOADING_CACHE = CacheBuilder.newBuilder().build(
            new CacheLoader<String, Object>() {
                @Override
                public Object load(String key) throws Exception {
                    log.info("load value for key {}", key);
                    return String.format("value of %s", key);
                }
            });
    private static final Cache<String, Object> MAXSIZE_CACHE = CacheBuilder.newBuilder()
            .maximumSize(5)
            .removalListener(notification -> {
                log.info("{} = {} removed", notification.getKey(), notification.getValue());
            }).build();
    private static final Cache<String, Object> EXPIRE_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .concurrencyLevel(1)
            .removalListener(notification -> {
                log.info("{} = {} removed", notification.getKey(), notification.getValue());
            }).build();
    private static final Cache<String, Object> WEAK_KEY_CACHE = CacheBuilder.newBuilder()
            .concurrencyLevel(1)
            .weakKeys()
            .removalListener(notification -> {
                log.info("{} = {} removed", notification.getKey(), notification.getValue());
            }).build();
    private static final Cache<String, Object> WEAK_VALUE_CACHE = CacheBuilder.newBuilder()
            .concurrencyLevel(1)
            .weakValues()
            .removalListener(notification -> {
                log.info("{} = {} removed", notification.getKey(), notification.getValue());
            }).build();

    private static void testLoadingCache() throws ExecutionException {
        log.info("{}", LOADING_CACHE.get("k1"));
        log.info("{}", LOADING_CACHE.get("k1"));
    }

    private static void testMaxSizeCache() {
        IntStream.range(0, 6).forEach(i -> {
            String key = String.format("k-%s", i);
            MAXSIZE_CACHE.put(key, "value");
        });

        IntStream.range(1, 6).forEach(i -> {
            String key = String.format("k-%s", i);
            try {
                log.info("{} = {}", key, MAXSIZE_CACHE.get(key, () -> "it is null"));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static void testExpireCache() {
        IntStream.range(0, 6).forEach(i -> {
            String key = String.format("key-%s", i);
            log.info("putting {}", key);
            EXPIRE_CACHE.put(key, String.format("value of %s", key));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void testWeakKeyCache() throws ExecutionException {
        String keyX = "key-x";
        WEAK_KEY_CACHE.put(keyX, "value of key-x");
        IntStream.range(0, 6).forEach(i -> {
            String key = String.format("key-%s", i);
            log.info("putting {}", key);
            WEAK_KEY_CACHE.put(key, String.format("value of %s", key));
            try {
                log.info("getting {} = {}", key, WEAK_KEY_CACHE.get(key, ()->"it null"));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.gc();
        log.info("key-x = {}", WEAK_KEY_CACHE.get(keyX, () -> "key-x is null"));
        log.info("key-0 = {}", WEAK_KEY_CACHE.get("key-0", () -> "key-0 is null"));
    }

    private static void testWeakValueCache() throws ExecutionException {
        String vx = "value of vx";
        WEAK_VALUE_CACHE.put("key-x", vx);
        IntStream.range(0, 6).forEach(i -> {
            String key = String.format("key-%s", i);
            String value = String.format("value of %s", key);
            WEAK_VALUE_CACHE.put(key, value);
        });
        System.gc();
        log.info("key-x = {}", WEAK_VALUE_CACHE.get("key-x", ()-> "vx is null"));
        log.info("key-0 = {}", WEAK_VALUE_CACHE.get("key-0", ()-> "v0 is null"));
        log.info("{}", WEAK_KEY_CACHE.stats());
    }

    public static void main(String[] args) throws ExecutionException {
//        testLoadingCache();
//        testMaxSizeCache();
//        testExpireCache();
//        testWeakKeyCache();
        testWeakValueCache();
    }
}
