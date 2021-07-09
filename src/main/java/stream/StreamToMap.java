package stream;


import static java.util.function.Function.identity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamToMap {
    @Data
    @AllArgsConstructor
    static class Point {
        private String name;
        private int x;
        private int y;
    }

    public static void main(String[] args) {
        List<Point> points = Lists.newArrayList(
                new Point("p1", 10, 20),
                new Point("p2", 1, 2),
//                new Point("p2", 1, 2),  // Note: duplicate key will trigger IllegalStateException
                new Point("p3", 11, 22)
        );
        Map<String, Point> pointMap = points.stream()
                .collect(Collectors.toMap(Point::getName, identity()));
        log.info("pointMap is {}", pointMap);
    }
}
