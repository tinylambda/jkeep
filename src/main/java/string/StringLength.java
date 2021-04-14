package string;


import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringLength {
    public static void main(String[] args) throws Exception {
        String testString = "Hello world";
        log.info("" + testString.length());

        String hashedString = Hashing.md5().hashString(testString, StandardCharsets.UTF_8).toString();
        log.info(hashedString);
        log.info("" + hashedString.length());
    }
}
