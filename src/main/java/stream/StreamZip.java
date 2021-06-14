package stream;


import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamZip {
    public static void main(String[] args) {
        List<Integer> listOne = Lists.newArrayList(1,2,3);
        List<Integer> listTwo = Lists.newArrayList(10, 20, 30);
        Streams.zip(listOne.stream(), listTwo.stream(), Integer::sum).forEach(item -> log.info("{}", item));
    }
}
