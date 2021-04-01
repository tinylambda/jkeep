package rx;

import io.reactivex.rxjava3.core.Flowable;

public class RxAssemblyTime {
    public static void main(String[] args) {
        Flowable<Integer> flow = Flowable.range(1, 5)
                .map(v -> v * v)
                .filter(v -> v % 3 == 0);
        flow.subscribe(System.out::println);
    }
}
