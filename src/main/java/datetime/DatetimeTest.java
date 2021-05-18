package datetime;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatetimeTest {
    public static void main(String[] args) throws InterruptedException {
        long old = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(3);
        log.info("" + (System.currentTimeMillis() - old) / 1000);
    }
}
