package stream;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamJoining {
    public static void main(String[] args) {
       String result = Stream.of("hello", "world", null)
               .filter(Objects::nonNull)
               .collect(Collectors.joining(";"));
       log.info("{}", result);

       result = Stream.<String>of(null, null)
               .filter(Objects::nonNull)
               .collect(Collectors.joining(";"));
       log.info("hi:{}", result);
    }
}
