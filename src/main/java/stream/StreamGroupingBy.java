package stream;


import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamGroupingBy {
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

        Map<String, List<Point>> map = points.stream().collect(groupingBy(Point::getName));
        log.info("{}", map);
        Map<Boolean, List<Point>> groups = points.stream().collect(groupingBy(item -> item.getX() > 100));
        log.info("{}", groups);  // key not exists: true
    }
}
