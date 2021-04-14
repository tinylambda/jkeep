package rx;


import io.reactivex.rxjava3.core.Flowable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxHelloWorld {
    public static void main(String[] args) {
        Flowable.just("Hello world")
                .subscribe(item -> log.info(String.valueOf(item)));
    }
}
