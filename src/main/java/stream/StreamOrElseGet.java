package stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamOrElseGet {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        int result = integers.stream().findFirst().orElseGet(() -> random.nextInt(100));
        log.info("{}", result);
    }
}
