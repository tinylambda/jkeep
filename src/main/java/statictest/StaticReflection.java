package statictest;

import java.lang.reflect.Field;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticReflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String name = "X1";
        Field field = Meta.class.getDeclaredField(name);
        String result = (String) field.get(null);
        log.info(result);
    }
}
