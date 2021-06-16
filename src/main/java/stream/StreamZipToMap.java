package stream;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

import io.vavr.Tuple2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamZipToMap {
    public static void main(String[] args) {
        List<Integer> listOne = Lists.newArrayList(1,2,3);
        List<Integer> listTwo = Lists.newArrayList(10, 20, 30);
        Map<Object, Object> result = Streams.zip(listOne.stream(), listTwo.stream(), (BiFunction<Integer, Integer, Tuple2>) Tuple2::new)
                .collect(Collectors.toMap(Tuple2::_1, tuple2 -> tuple2._2));
        log.info("{}", result);
    }
}
