package generic;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Collections.emptyMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.google.common.base.Joiner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericSimpleCache {
    private static final String DATASET_KEY_DELIMITER = "-";
    private Map<String, Map<String, List<Integer>>> db = newHashMap();

    public GenericSimpleCache() {
        // don't initialize object in constructor method, here just for example
        db.computeIfAbsent("online-activityId", key -> newHashMap())
                .put("true-gu_t1", newArrayList(1, 2, 3, 4, 5, 6, 7, 8));
        db.computeIfAbsent("online-activityId-publishDay", key -> newHashMap())
                .put("true-gu_t1-20210601", newArrayList(1, 2));
        db.computeIfAbsent("online-activityId-publishDay", key -> newHashMap())
                .put("true-gu_t1-20210602", newArrayList(3, 4, 5, 6, 7, 8));
    }

    private String toDataSetKey(List<String> columns) {
        return Joiner.on(DATASET_KEY_DELIMITER).join(columns);
    }

    private final Map<String, Map<String, Object>> summaryCache = newHashMap();

    public void summary(String name, List<String> columns, Function<Map<String, List<Integer>>, Object> how) {
        String dataSetKey = toDataSetKey(columns);
        Map<String, List<Integer>> dataSet = db.getOrDefault(dataSetKey, emptyMap());
        Object value = how.apply(dataSet);
        summaryCache.computeIfAbsent(dataSetKey, k -> newHashMap()).put(name, value);
    }

    @Nullable
    public <T> T getSummary(String name, List<String> columns) {
        String dataSetKey = toDataSetKey(columns);
        Object value = summaryCache.getOrDefault(dataSetKey, emptyMap()).get(name);
        return value == null ? null : (T) value;
    }

    public static void main(String[] args) {
        GenericSimpleCache genericSimpleCache = new GenericSimpleCache();
        genericSimpleCache.summary(
                "longestList",
                newArrayList("online", "activityId", "publishDay"),
                v -> {
                    long maxLength = 0L;
                    List<Integer> longestList = null;
                    for (Map.Entry<String, List<Integer>> entry : v.entrySet()) {
                        List<Integer> currentList = entry.getValue();
                        int currentSize = currentList.size();
                        if (currentSize > maxLength) {
                            longestList = currentList;
                            maxLength = currentSize;
                        }
                    }
                    return longestList;
                }
        );

        log.info("{}", genericSimpleCache.<List<Integer>>getSummary("longestList",
                newArrayList("online", "activityId", "publishDay")));
    }
}
