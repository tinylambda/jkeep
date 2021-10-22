package stream;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public class StreamFindAny {
    public static void main(String[] args) {
        List<String> choices = newArrayList("kt", "jj", "vc");
        Collections.shuffle(choices);
        log.info("{}", choices.stream().findAny());
    }
}
