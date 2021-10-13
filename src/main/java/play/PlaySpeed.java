package play;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-12
 */
@Slf4j
public class PlaySpeed {
    public static void main(String[] args) {
        log.info("{}", System.currentTimeMillis());
        log.info("{}", System.currentTimeMillis());
        log.info("{}", System.currentTimeMillis() - System.currentTimeMillis());
        log.info("{}", System.currentTimeMillis() - System.currentTimeMillis());
        log.info("{}", System.currentTimeMillis() - System.currentTimeMillis());
    }
}
