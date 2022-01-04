package collections.map;

import static com.google.common.collect.Maps.newEnumMap;

import java.util.EnumMap;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2022-01-04
 */
@Slf4j
public class MapEnumMap {
    enum Colors {
        RED,
        GREEN,
        BLUE,
        PURPLE,
    }

    public static void main(String[] args) {
        EnumMap<Colors, String> enumMap = newEnumMap(Colors.class);
        enumMap.put(Colors.BLUE, "bad");
        enumMap.put(Colors.RED, "good");
        enumMap.put(Colors.GREEN, "medium");
        enumMap.put(Colors.PURPLE, "well");
        log.info("{}", enumMap);
    }
}
