package collections.tuple;

import io.vavr.Tuple;
import io.vavr.Tuple4;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TupleVavr {
    public static void main(String[] args) {
        Tuple4<Integer, Integer, Integer, Integer> tuple = Tuple.of(1, 2, 3, 4);
        log.info("{}", tuple);
        log.info("{}", tuple._1);
        log.info("{}", tuple._1());
    }
}
