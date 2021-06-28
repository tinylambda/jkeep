package stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamGroupingByAdvanced {
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
                new Point("x", 1, 20),
                new Point("x", 100, 200),
                new Point("y", 7, 8),
                new Point("y", 70, 80)
        );

        Map<String, List<Point>> mapOne = points.stream().collect(groupingBy(Point::getName));
        log.info("{}", mapOne);

        Map<String, Set<Point>> mapTwo = points.stream().collect(groupingBy(Point::getName, toSet()));
        log.info("{}", mapTwo);

        Map<String, List<Integer>> mapThree = points.stream()
                .collect(groupingBy(Point::getName, mapping(Point::getX, toList())));
        log.info("{}", mapThree);

        Map<String, Set<Integer>> mapFour = points.stream()
                .collect(groupingBy(Point::getName, mapping(Point::getX, toSet())));
        log.info("{}", mapFour);
    }
}
