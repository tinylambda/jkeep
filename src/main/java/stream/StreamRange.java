package stream;


import io.vavr.collection.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamRange {
    public static void main(String[] args) {
        int maxNum = 10;
        Stream.rangeBy(0, maxNum + 1, 1)
                .forEach(item -> log.info("{}", item));
    }
}
