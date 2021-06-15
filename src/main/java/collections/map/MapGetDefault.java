package collections.map;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapGetDefault {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("x", 100);
        map.put("y", 200);

        log.info("{}", map.getOrDefault("z", 1000));
    }
}
