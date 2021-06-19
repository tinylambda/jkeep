package stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        Map<String, List<Point>> map = points.stream().collect(Collectors.groupingBy(Point::getName));
        log.info("{}", map);
    }
}
