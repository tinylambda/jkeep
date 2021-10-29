package datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-28
 */
@Slf4j
public class DatetimeAddDays {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.now();
        log.info("{}", localDate.format(formatter));

        LocalDate newDate = localDate.plusDays(-1);
        log.info("{}", newDate.format(formatter));
    }
}
