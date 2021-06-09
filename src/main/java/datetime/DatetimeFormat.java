package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatetimeFormat {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        log.info(sdf.format(new Date()));
        log.info(sdf.format(System.currentTimeMillis()));

        long dateLongRepresentation = 20210609;
        String dateStringRepresentation = Long.toString(dateLongRepresentation);
        log.info(dateStringRepresentation);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = simpleDateFormat.parse(dateStringRepresentation);
        log.info("date is {}", date);

        long ts = System.currentTimeMillis();
        date = new Date(ts);
        sdf = new SimpleDateFormat("yyyyMMdd");
        dateStringRepresentation = sdf.format(ts);
        log.info(dateStringRepresentation);
    }
}
