package playground.basic;

import lombok.extern.slf4j.Slf4j;
import object.ObjectHashCode;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-22
 */
@Slf4j
public class BasicLongToString {
    public static void main(String[] args) {
        Long x = 1000L;
        Object y = "1000";

        String x1 = String.valueOf(x);
        String x2 = "" + x;
        Long x3 = Long.valueOf(y + "");

        log.info("{}, {}, {}", x1, x2, x3);
    }
}
