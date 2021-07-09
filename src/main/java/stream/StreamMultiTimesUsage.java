package stream;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamMultiTimesUsage {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c");
        Stream<String> stringStream = list.stream();
        List<String> x = stringStream.map(s -> s + ".").collect(toList());
        List<String> y = stringStream.map(s -> s + "!").collect(toList());
        log.info("{}", x);
        log.info("{}", y);
    }
}
