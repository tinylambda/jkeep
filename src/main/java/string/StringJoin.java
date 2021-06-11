package string;

import com.google.common.base.Joiner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringJoin {
    public static void main(String[] args) {
        String[] parts = {"hello", "world", "!"};
        log.info(String.join(" ", parts));
        log.info(Joiner.on(" ").join(parts));

        Object[] objects = {"hello", 1, 2, 3.4, "world"};
        log.info(Joiner.on("&").join(objects));
    }
}
