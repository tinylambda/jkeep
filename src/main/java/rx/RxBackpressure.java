package rx;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxBackpressure {
    public static void main(String[] args) throws InterruptedException, IOException {
        java.lang.Process process = Runtime.getRuntime().exec(new String[] {"python", "-c", "import os; print(os.getppid())"});
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        String s = null;
        while ((s = stdError.readLine()) != null) {
            log.info(s);
        }
        while ((s = stdInput.readLine()) != null) {
            log.info(s);
        }

        log.info(Thread.currentThread().getName());
        Observable.interval(2, TimeUnit.MILLISECONDS)
        .observeOn(Schedulers.newThread())
        .subscribe(l -> {
            try {
                log.info(Thread.currentThread().getName());
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.warn("TAG" + "--->" + l);
        });
        TimeUnit.SECONDS.sleep(1000);
    }
}
