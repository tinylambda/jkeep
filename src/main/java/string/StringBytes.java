package string;

import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringBytes {
    public static void main(String[] args) {
        String s = "hello world 中国";
        log.info("{}", s);
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        log.info("{}", bytes);
        log.info("{}", new String(bytes));
    }
}
