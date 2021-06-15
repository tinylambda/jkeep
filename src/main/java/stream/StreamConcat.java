package stream;


import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

import io.vavr.collection.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamConcat {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.range(0, 10);
        Stream<Integer> s2 = Stream.range(100, 110);
        Stream.concat(s1, s2).forEach(item -> log.info("{}", item));

        List<Integer> listOne = Lists.newArrayList(1,2,3);
        List<Integer> listTwo = Lists.newArrayList(10, 20, 30);
        Streams.concat(listOne.stream(), listTwo.stream()).forEach(item -> log.info("{}", item));
    }
}
