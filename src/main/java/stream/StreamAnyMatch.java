package stream;


import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamAnyMatch {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
        log.info("{}", integers.stream().anyMatch(item -> item > 4));
        integers = Collections.emptyList();
        log.info("{}", integers.stream().anyMatch(item -> item > 4));
    }
}
