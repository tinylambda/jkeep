package playground.basic;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-24
 */
@Slf4j
public class BasicCovert {
    public static void main(String[] args) {
        Map<String, Object> map = newHashMap();
        map.put("a", "hello");
        map.put("b", 1000L);

        log.info("{}", (String) map.get("a"));  // hello
        log.info("{}", (String) map.get("c"));  // null
//        log.info("{}", (String) map.get("b"));  // java.lang.ClassCastException

        log.info("{}", map.get("a").toString());  // hello
//        log.info("{}", map.get("c").toString()); // java.lang.NullPointerException
        log.info("{}", map.get("b").toString()); // 1000
    }
}
