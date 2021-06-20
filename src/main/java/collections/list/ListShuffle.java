package collections.list;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListShuffle {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
        log.info("{}", integers);
        Collections.shuffle(integers);
        log.info("{}", integers);
    }
}
