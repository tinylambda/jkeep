package playground.basic;

import static com.google.common.collect.Maps.newConcurrentMap;
import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;
import java.util.Map.Entry;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-20
 */
@Slf4j
public class BasicMapElementRemove {
    public static void main(String[] args) {
        // java.util.ConcurrentModificationException
//        Map<String, String> map = newHashMap();
        // this is OK
        Map<String, String> map = newConcurrentMap();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        for (Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.equals("b")) {
                map.remove(key);
            }
        }

        log.info("{}", map);
    }
}
