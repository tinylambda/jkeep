package log;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogBasic {
    public void test() {
        log.info("go");
    }
    public static void main(String[] args) {
        LogBasic logBasic = new LogBasic();
        logBasic.test();
    }
}
