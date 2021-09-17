package stream;


import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamBlocks {
    public static void main(String[] args) {
        List<String> items = newArrayList("1", "2", "3", "4", "5", "6", "7");
        AtomicLong i = new AtomicLong();
        List<String> result = items.stream().map(item -> {i.addAndGet(1); return item + i;}).collect(Collectors.toList());
        log.info("{}", result);
    }
}
