package stream;


import java.util.List;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamOrElse {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList();
        int result = integers.stream().findFirst().orElse(10);
        log.info("{}", result);

        integers.add(200);
        result = integers.stream().findFirst().orElse(1000);
        log.info("{}", result);
    }
}

