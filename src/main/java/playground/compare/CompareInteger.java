package playground.compare;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-20
 */
@Slf4j
public class CompareInteger {
    public static void main(String[] args) {
        int testValue = 10000;

        Integer v1 = 10000;
        Integer v2 = 10000;
        Integer v3 = 20000;

        log.info("{}", testValue == v1);
        log.info("{}", testValue == v2);
        log.info("{}", testValue == v3);

        log.info("X0: {}", v1 == v2);
        log.info("X1: {}", v1.equals(v2));
        log.info("X2: {}", Objects.equals(v1, v2));
        log.info("X3: {}", Objects.equals(v1, v3));
    }
}
