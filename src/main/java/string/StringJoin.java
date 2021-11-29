package string;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

        objects = new Object[] {"hello", 1, 2, 3.4, "world", null};

        // null value will cause join throw NPE
        objects = Arrays.stream(objects).filter(Objects::nonNull).toArray();
        log.info(Joiner.on(";").join(objects));

        // Join just one element
        List<String> items = newArrayList("hello");
        log.info("join by OR: {}", Joiner.on(" OR ").join(items));
    }
}
