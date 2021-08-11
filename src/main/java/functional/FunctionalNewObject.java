package functional;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Streams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalNewObject
{

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Integer> xList = newArrayList();
        List<Integer> yList = newArrayList();
        xList.add(1);
        xList.add(2);
        xList.add(3);
        xList.forEach(item -> yList.add(item * 10));

        List<Point> points = Streams.zip(xList.stream(), yList.stream(), Point::new).collect(Collectors.toList());
        log.info("result is {}", points);
    }
}
