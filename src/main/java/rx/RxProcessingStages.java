package rx;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxProcessingStages {
    public static void main(String[] args) {
        Flowable.range(1, 10)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe(System.out::println);
    }
}
