package utilclass;


import static java.lang.Thread.sleep;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilStopWatch {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = StopWatch.createStarted();
        sleep(1000);
        log.info("from start to now: {} ms", stopWatch.getTime());
        sleep(1000);
        stopWatch.split();
        log.info("from start to now: {} ms", stopWatch.getTime());
        log.info("from start to first bp: {} ms", stopWatch.getSplitTime());

        sleep(1000);
        stopWatch.split();
        log.info("from start to second bp: {} ms", stopWatch.getSplitTime());

        stopWatch.reset();
        stopWatch.start();
        sleep(1000);
        log.info("from reset to now: {} ms", stopWatch.getTime());

        stopWatch.suspend();
        sleep(6000);
        stopWatch.resume();
        log.info("after resume: {} ms", stopWatch.getTime());

        stopWatch.stop();
        log.info("cost time: {} ms", stopWatch.getTime());
        log.info("cost time: {} s", stopWatch.getTime(TimeUnit.SECONDS));
    }
}
