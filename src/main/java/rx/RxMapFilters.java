package rx;


import java.util.Arrays;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RxMapFilters {
    public static void main(String[] args) {
        Observable.range(1, 100)
        .map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) throws Exception {
                return i * i;
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Throwable {
                return integer % 2 == 0;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Throwable {
                log.info("get result: " + integer);
            }
        });
    }
}
