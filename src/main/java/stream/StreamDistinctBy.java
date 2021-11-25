package stream;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-25
 */
@Slf4j
public class StreamDistinctBy {
    @Data
    @AllArgsConstructor(access = AccessLevel.PUBLIC)
    static class Point {
        private int x;
        private int y;
    }

    public static void main(String[] args) {
        List<Point> points = newArrayList(
                new Point(100, 200), new Point(100, 300), new Point(100, 500),
                new Point(1000, 2000), new Point(1000, 500), new Point(8000, 20)
        );
        List<Point> distinctPoints =
                points.stream().collect(Collectors.groupingBy(Point::getX)).values().stream().map(pointList -> pointList.get(0)).collect(Collectors.toList());
        log.info("{}", distinctPoints);
    }
}
