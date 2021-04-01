package rx;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxBackground {
    public static void main(String[] args) throws Exception {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);
        Thread.sleep(2000);
    }
}
