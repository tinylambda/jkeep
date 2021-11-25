package stream;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-25
 */
@Slf4j
public class StreamDistinct {
    public static void main(String[] args) {
        List<String> items = newArrayList("a", "b", "c", "a", "b");
        List<String> newItems = items.stream().distinct().collect(Collectors.toList());
        log.info("{}", newItems);
    }
}
