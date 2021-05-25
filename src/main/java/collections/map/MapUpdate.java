package collections.map;


import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapUpdate {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("x", 1);
        map.put("y", 2);
        map.put("z", 3);
        log.info("original map {}", map);

        Map<String, Integer> updateMap = new HashMap<>();
        updateMap.put("x", 100);
        updateMap.put("y", 200);

        map.putAll(updateMap);
        log.info("updated map {}", map);
    }
}
