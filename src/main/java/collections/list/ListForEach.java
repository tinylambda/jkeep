package collections.list;


import java.util.List;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListForEach {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, null, 4, 5, 6, null, 7);
        List<Integer> nonNullIntegers = Lists.newArrayList();
        integers.forEach(item -> {
            if (item == null) {
                return;
            }
            nonNullIntegers.add(item);
        });
        log.info("{}", nonNullIntegers);
    }
}
