package datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatetimeFormat {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        log.info(sdf.format(new Date()));
        log.info(sdf.format(System.currentTimeMillis()));
    }
}
