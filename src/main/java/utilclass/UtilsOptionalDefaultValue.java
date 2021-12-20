package utilclass;

import java.util.Optional;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-20
 */
@Slf4j
public class UtilsOptionalDefaultValue {
    private static final Random RANDOM = new Random();

    private static Integer getInt() {
        int x = RANDOM.nextInt(100);
        if (x > 50) {
            return x;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer x = Optional.ofNullable(getInt()).orElse(1);
        log.info("{}", x);
    }
}
