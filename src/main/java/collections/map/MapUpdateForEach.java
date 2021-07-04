package collections.map;


import java.util.Map;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapUpdateForEach {
    public static void main(String[] args) {
        Map<Long, Object> mapOne = Maps.newHashMap();
        Map<Long, Object> mapTwo = Maps.newHashMap();
        mapOne.put(1L, 20);
        mapOne.put(2L, 30);

        mapTwo.put(3L, 40);
        mapTwo.put(4L, 50);

        Map<Long, Object> result = Maps.newHashMap();
        result.putAll(mapOne);
        result.putAll(mapTwo);
        log.info("{}", result);

        mapOne.forEach((k, v) -> {
            if ((int) v > 20) {
                result.put(k, v);
            }
        });

        log.info("{}", result);
    }
}
