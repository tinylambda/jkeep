package stream;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamFindFirst {
    public static void main(String[] args) {
        List<String> list = newArrayList("go");
        String s = list.stream().findFirst().orElse(null);
        log.info("result is {}", s);

        List<Integer> integers = newArrayList(1, 2, 3, 4, 5, 6, 7);
        Integer integer = integers.stream().map(i -> {
            log.info("computing {}", i);
            int mul = i * 10;
            if (mul < 20) {
                return null;
            }
            return mul;
        }).filter(Objects::nonNull).findFirst().orElse(-1);
        log.info("{}", integer);
    }
}
