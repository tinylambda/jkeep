package collections.map;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapComputeIfAbsent {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Integer integer = map.computeIfAbsent("key", k -> 1000);
        log.info("the data is {}", integer);
    }
}
