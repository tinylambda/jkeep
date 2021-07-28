package annotation;


import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnnotationNotNullNonNull {
    @NotNull private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    @Nonnull
    public Integer getAge() {
        return age;
    }

    public static void main(String[] args) {
        @Valid AnnotationNotNullNonNull object = new AnnotationNotNullNonNull();
        log.info("{}", object.getName());
        log.info("{}", object.getAge());
    }
}
