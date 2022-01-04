package enums;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2022-01-04
 */
@Slf4j
public class EnumOrdinal {
    enum Colors {
        RED,
        GREEN,
        BLUE,
        PURPLE,
    }

    @AllArgsConstructor
    enum Level {
        GOOD(100),
        BAD(200),
        ;
        private int v;
    }

    public static void main(String[] args) {
        log.info("GREEN ordinal: {}", Colors.GREEN.ordinal());
        log.info("BAD ordinal: {}", Level.BAD.ordinal());
    }
}
