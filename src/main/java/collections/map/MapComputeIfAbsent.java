package collections.map;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapComputeIfAbsent {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("x", 2000);
        Integer integer = map.computeIfAbsent("key", k -> 1000);
        log.info("the data is {}", integer);
        integer = map.computeIfAbsent("x", k -> 9999);
        log.info("the data is {}", integer);
    }
}
