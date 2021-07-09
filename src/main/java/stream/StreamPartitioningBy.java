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
        List<Point> points = Lists.newArrayList(
                new Point("x", 1, 2),
                new Point("x", 10, 20),
                new Point("x", 100, 200),
                new Point("y", 7, 8),
                new Point("y", 70, 80)
        );

        Map<Boolean, List<Point>>
                groups = points.stream().collect(partitioningBy(item -> item.getX() > 1000));
        log.info("{}", groups);  // key exists: true
    }
}
