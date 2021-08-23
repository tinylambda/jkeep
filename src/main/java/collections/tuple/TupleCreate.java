package collections.tuple;


import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TupleCreate {
    public static void main(String[] args) {
        Pair<Integer, Integer> pair = Pair.of(1, 2);
        log.info("Pair: {}", pair);

        Triple<Integer, Integer, Integer> triple = Triple.of(1, 2, 3);
        log.info("Triple: {}", triple);
    }
}
