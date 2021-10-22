package collections.set;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import org.apache.commons.collections4.SetUtils;

import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public class SetOps {
    public static void main(String[] args) {
        Set<String> s1 = newHashSet("a", "b", "c");
        Set<String> s2 = newHashSet("d", "m", "c");

        log.info("apache intersection {}", SetUtils.intersection(s1, s2));
        log.info("apache diff {}", SetUtils.difference(s1, s2));

        log.info("guava intersection {}", Sets.intersection(s1, s2));
        log.info("guava diff {}", Sets.difference(s1, s2));

        s1.retainAll(s2);
        log.info("s1: {}", s1);
        log.info("s2: {}", s2);
    }
}
