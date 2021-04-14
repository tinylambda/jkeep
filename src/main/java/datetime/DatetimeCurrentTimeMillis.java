package datetime;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatetimeCurrentTimeMillis {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        log.info("currentTimeMillis: " + currentTimeMillis);
    }
}
