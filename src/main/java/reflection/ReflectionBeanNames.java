package reflection;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.annotation.Nonnull;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ReflectionBeanNames {
    @Nonnull
    private Integer x=1;
    @Nonnull
    private Integer y=2;
    @Nonnull
    private Integer z=3;

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ReflectionBeanNames reflectionBeanNames = new ReflectionBeanNames();
       for (Field field : ReflectionBeanNames.class.getDeclaredFields()) {
           if (field.isAnnotationPresent(Nonnull.class)) {
               log.info("got field: " + field.getName());
               log.info("it's type is: " + field.getType());
               Class fieldType = field.getType();
               Object value = field.get(reflectionBeanNames);
               log.info("it's value is: " + fieldType.cast(value));
           }
       }
    }
}
