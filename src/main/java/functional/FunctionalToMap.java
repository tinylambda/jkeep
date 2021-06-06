package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalToMap {
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
        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);

        Map<String, Point> map = points.stream().collect(Collectors.toMap(item -> item.name, item->item));
        log.info("result is {}", map);
    }
}
