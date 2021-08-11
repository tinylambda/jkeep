package functional;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalToMap {
    @Data
    static class Point {
        private String name;
        private int x;
        private int y;

        public Point(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "name='" + name + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point("p1", 1, 2);
        Point p2 = new Point("p2", 10, 20);
        List<Point> points = newArrayList();
        points.add(p1);
        points.add(p2);

        Map<String, Point> map = points.stream().collect(Collectors.toMap(item -> item.name, item->item));
        log.info("result is {}", map);

        map = points.stream().collect(Collectors.toMap(Point::getName, item -> item));
        log.info("result is {}", map);

        points.clear();
        map = points.stream().collect(Collectors.toMap(Point::getName, item->item));
        log.info("result is {}", map);  // will be an empty map

        Point p3 = new Point("p1", 2, 3);
        Point p4 = new Point("p2", 11, 21);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        Map<String, List<Point>> pointListByName = newHashMap();
        for (Point point : points) {
            pointListByName.computeIfAbsent(point.getName(), k -> newArrayList()).add(point);
        }
        log.info("pointListByName is {}", pointListByName);
    }
}
