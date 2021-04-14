package string;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringCompare {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "Hello";
        String s3 = "world";
        log.info("" + s1.compareTo(s1));
        log.info("" + s1.compareTo(s2));
        log.info("" + s1.compareToIgnoreCase(s2));
        log.info("" + s1.compareTo(s3));
    }
}
