package rx;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxImmutable {
    public static void main(String[] args) throws Exception {
        Flowable<String> source = Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        });

        Flowable<String> runBackground = source.subscribeOn(Schedulers.io());
        Flowable<String> showForeground = runBackground.observeOn(Schedulers.single());
        showForeground.subscribe(item -> log.info(String.valueOf(item)), Throwable::printStackTrace);
        Thread.sleep(2000);
    }
}
