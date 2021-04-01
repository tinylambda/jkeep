package rx;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxParallel {
    public static void main(String[] args) {
        Flowable.range(1, 10)
                .flatMap(
                        v -> Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);

        System.out.println("splitter");

        Flowable.range(1, 10)
                .parallel()
                .runOn(Schedulers.computation())
                .map(v -> v * v)
                .sequential()
                .blockingSubscribe(System.out::println);
    }
}
