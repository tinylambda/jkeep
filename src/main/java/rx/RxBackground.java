package rx;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxBackground {
    public static void main(String[] args) throws Exception {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(item -> log.info(String.valueOf(item)), Throwable::printStackTrace);
        Thread.sleep(2000);
    }
}
