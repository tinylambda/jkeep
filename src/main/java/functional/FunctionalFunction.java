package functional;


import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionalFunction {
    @FunctionalInterface
    interface Foo {
        String method(String s);
        default Integer method2(String s) {
            log.info("default method2");
            return s.length();
        };
        default void defaultMethod(String s) {
            log.info("hello default method {}", s);
        }
    }

    private String doFoo(String s, Foo foo) {
        foo.defaultMethod(s);
        foo.method2("googogo");
        return foo.method(s);
    }

    private String add(String s, Function<String, String> fn) {
        return fn.apply(s);
    }

    public static void main(String[] args) {
        FunctionalFunction ff = new FunctionalFunction();
        String result1 = ff.add("hello", item -> item + " world!");
        String result2 = ff.add("go", item -> item + " world!");
        log.info("{}", result1);
        log.info("{}", result2);

        Foo foo = item -> "get " + item + "!";
        String result3 = ff.doFoo("World", foo);
        log.info("{}", result3);
    }
}
