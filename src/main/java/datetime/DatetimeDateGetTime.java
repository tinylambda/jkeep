package datetime;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatetimeDateGetTime {
    public static void main(String[] args) {
        log.info("" + new Date().getTime());
        log.info("" + System.currentTimeMillis());
    }
}
