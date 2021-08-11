package functional;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalBasic {
    public static void main(String[] args) {
        List<Integer> list = newArrayList();
        for (int i=0; i<10; i++) {
            list.add(i);
        }

        list.stream()
                .filter(item -> item % 2 == 0)
                .forEach(item -> log.info("{}", item));
    }
}
