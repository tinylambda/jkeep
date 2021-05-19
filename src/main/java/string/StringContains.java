package string;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringContains {
    public static void main(String[] args) {
        String s = "hello this is a test server";
        log.info("" + s.contains("test"));
        log.info("" + s.contains("xxx"));
    }
}
