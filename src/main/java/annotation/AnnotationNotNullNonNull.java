package annotation;


import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnotationNotNullNonNull {
    private String name=null;
    private Integer age=null;

    @NotNull
    public String getName() {
        return name;
    }

    @Nonnull
    public Integer getAge() {
        return age;
    }

    public static void main(String[] args) {
        AnnotationNotNullNonNull object = new AnnotationNotNullNonNull();
        object.name = "felix";
        object.age = 19;
        log.info("{}", object.getName());
        log.info("{}", object.getAge());
    }
}
