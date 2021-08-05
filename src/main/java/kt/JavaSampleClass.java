package kt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JavaSampleClass {
    public static void doSomething() {
        log.info("do something");
    }

    public static void testClass(Class<? extends JavaSampleClass> clazz) {
        log.info("good");
    }
}
