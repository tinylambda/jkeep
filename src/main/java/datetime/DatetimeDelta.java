package datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatetimeDelta {
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillis = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2021, 5, 1, 12, 23, 21);
        Date dateOne = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        Date dateTwo = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        log.info(sdf.format(dateOne));
        log.info(sdf.format(dateTwo));
        log.info("{} seconds passed", getDateDiff(dateOne, dateTwo, TimeUnit.SECONDS));

        dateOne = new GregorianCalendar(2021, Calendar.OCTOBER, 21).getTime();
        dateTwo = new GregorianCalendar(2021, Calendar.OCTOBER, 27).getTime();
        log.info("{} days passed", getDateDiff(dateOne, dateTwo, TimeUnit.DAYS));
    }
}
