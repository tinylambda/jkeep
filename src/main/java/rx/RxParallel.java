package rx;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxParallel {
    public static void main(String[] args) {
        Flowable.range(1, 10)
                .flatMap(
                        v -> Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(item -> log.info(String.valueOf(item)));

        log.info("splitter");

        Flowable.range(1, 10)
                .parallel()
                .runOn(Schedulers.computation())
                .map(v -> v * v)
                .sequential()
                .blockingSubscribe(item -> log.info(String.valueOf(item)));
    }
}
