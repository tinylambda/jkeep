package rx;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxMapFilters {
    public static void main(String[] args) {
        Observable.range(1, 100)
        .map(i -> i * i).filter(integer -> integer % 2 == 0).subscribe(integer -> log.info("get result: " + integer));
    }
}
