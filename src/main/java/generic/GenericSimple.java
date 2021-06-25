package generic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericSimple {
    public <T> T hello(T item) {
        return item;
    }

    public static void main(String[] args) {
        GenericSimple genericSimple = new GenericSimple();
        String itemString = genericSimple.<String>hello("world");
        log.info("{}", itemString);
        Integer itemInteger = genericSimple.<Integer>hello(100);
        log.info("{}", itemInteger);
        Long itemLong = genericSimple.<Long>hello(100L);
        log.info("{}", itemLong);
    }
}
