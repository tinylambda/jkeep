package collections.list;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListArrayListSort {
    public static void main(String[] args) {
        List<Map<String, Integer>> list = new ArrayList<>();
        // fill list
        for (int i=0; i<100; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("k", -i);
            list.add(map);
        }
        // print list items
        list.forEach(item -> {
            log.info("" + item);
        });
        // sort by value
        list.sort((m1, m2) -> {
            int v1 = m1.get("k");
            int v2 = m2.get("k");
            if (v1 == v2)
                return 0;
            if (v1 > v2)
                return 1;
            else
                return -1;
        });

        log.info("sorted: ");
        list.forEach(item -> {
            log.info("" + item);
        });
    }
}
