package annotation;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import utils.SpringRunnerTest;

@Slf4j
class AnnotationNotNullNonNullTest extends SpringRunnerTest {
    @Autowired
    private AnnotationNotNullNonNull annotationNotNullNonNull;

    @Test
    @Valid
    void getName() {
        String name = annotationNotNullNonNull.getName();
        log.info("{}", name);
    }

    @Test
    void getAge() {
    }
}