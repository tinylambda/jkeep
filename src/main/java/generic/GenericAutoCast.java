package generic;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericAutoCast {
    private static final Map<String, Object> cache = newHashMap();
    static {
        cache.put("string", "hello");
        cache.put("integer", 100);
        cache.put("long", 100L);
        cache.put("list", newArrayList());
    }

    public <T> T cacheGet(String key) {
        return (T) cache.get(key);
    }

    public static void main(String[] args) {
        GenericAutoCast genericAutoCast = new GenericAutoCast();
        log.info("{}", genericAutoCast.<List<String>>cacheGet("list"));
        log.info("{}", genericAutoCast.<Long>cacheGet("long"));
        log.info("{}", genericAutoCast.<Integer>cacheGet("integer"));
        log.info("{}", genericAutoCast.<String>cacheGet("string"));
        log.info("{}", genericAutoCast.<Integer>cacheGet("string")); // no error

        Integer integer = genericAutoCast.<Integer>cacheGet("string");  // cast exception
        log.info("{}", integer);
    }
}
