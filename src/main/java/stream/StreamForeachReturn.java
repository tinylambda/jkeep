package stream;


import java.util.List;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamForeachReturn {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(item -> {
            if (item % 2 != 0) {
                log.info("odd is {}", item);
            }
        });
    }
}
