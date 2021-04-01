package rx;


import io.reactivex.rxjava3.core.Flowable;

public class RxHelloWorld {
    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}
