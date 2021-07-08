package stream;

import java.util.List;

import org.apache.hadoop.shaded.com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamFindFirst {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("go");
        String s = list.stream().findFirst().orElse(null);
        log.info("result is {}", s);
    }
}
