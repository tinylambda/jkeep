package utilclass;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-08
 */
@Slf4j
public class UtilOptionalMap {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Map<String, Long> map = newHashMap();

        if (RANDOM.nextInt(100) > 50) {
            map = null;
        } else {
            map.put("cnt", 1000L);
        }
        Long cnt = Optional.ofNullable(map).orElse(Collections.emptyMap()).getOrDefault("cnt", 0L);
        log.info("cnt is {}", cnt);
    }
}
