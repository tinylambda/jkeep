package collections.map;


import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapEmptyGet {
    public static void main(String[] args) {
        Map<String, String> map = newHashMap();
        String v = map.get("k");
        log.info("{}", v);
    }
}
