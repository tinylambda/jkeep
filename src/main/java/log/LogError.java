package log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogError {
    public static void main(String[] args) {
        String info = "test info here";
        try {
            throw new RuntimeException("Hello exception");
        } catch (Exception e) {
            log.error("message: {}", info, e);
        }
    }
}
