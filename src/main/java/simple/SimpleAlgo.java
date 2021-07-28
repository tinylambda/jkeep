package simple;


import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleAlgo {
    private static boolean test(long key, int max, double percent) {
        int t = (int) (max * percent);
        return (key & (max - 1)) <= t;
    }
    public static void main(String[] args) {
        int max = 10;
        Map<String, Set<Long>> resultMap = newHashMap();
        LongStream.range(10000, 123445).forEach(key -> {
            IntStream.range(0, 100).forEach(i -> {
                double percent = i / 100.;
                boolean match = test(key, max, percent);
                String mapKey = String.format("%s-%s", max, percent);
                if (match) {
                    resultMap.computeIfAbsent(mapKey, k -> newHashSet()).add(key);
                }
            });
        });

        resultMap.forEach((k, v) -> {
            log.info("key<{}> -> {}", k, CollectionUtils.size(v));
        });

        Comparator<String> comparator = Comparator.comparingInt(k -> NumberUtils.toInt(k.split("-")[0]));
        comparator = comparator.thenComparingDouble(k -> NumberUtils.toDouble(k.split("-")[1]));

        Set<Long> keys = resultMap.get("10-0.79");
        resultMap.keySet().stream().sorted(comparator).forEach(k -> {
            log.info("key = {}, size of value = {}, flag={}",
                    k, CollectionUtils.size(resultMap.get(k)), CollectionUtils.containsAll(keys, resultMap.get(k))
            );
        });
    }
}
