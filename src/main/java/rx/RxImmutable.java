package rx;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxImmutable {
    public static void main(String[] args) throws Exception {
        Flowable<String> source = Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        });

        Flowable<String> runBackground = source.subscribeOn(Schedulers.io());
        Flowable<String> showForeground = runBackground.observeOn(Schedulers.single());
        showForeground.subscribe(System.out::println, Throwable::printStackTrace);
        Thread.sleep(2000);
    }
}
