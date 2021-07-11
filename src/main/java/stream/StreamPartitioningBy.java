package stream;

import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamPartitioningBy {
    @Data
    @AllArgsConstructor
    static class Point {
        private String name;
        private int x;
        private int y;
    }

    public static void main(String[] args) {
        List<Point> points = Lists.newArrayList();

        Map<Boolean, List<Point>>
                groups = points.stream().collect(partitioningBy(item -> item.getX() > 1000));
        log.info("{}", groups);  // key exists: true
    }
}
