package collections.set;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetContains {
    public static void main(String[] args) {
        Set<Long> longs = new HashSet<>();
        longs.add(100L);
        log.info("{}", longs.contains(100)); // false
        log.info("{}", longs.contains(100L)); // true
    }
}
