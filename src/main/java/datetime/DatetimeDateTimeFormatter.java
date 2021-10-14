package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-14
 */
@Slf4j
public class DatetimeDateTimeFormatter {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd:HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        log.info("{}", formatter.format(dateTime));
    }
}
