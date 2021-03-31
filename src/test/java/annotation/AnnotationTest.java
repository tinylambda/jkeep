package annotation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class AnnotationTest {
    @Test
    public void testAnnotation() {
        assertThrows(NullPointerException.class, () -> {
            AnnotationUseRequiredContext annotationUseRequiredContext = new AnnotationUseRequiredContext(null);
        });

        Map<String, Object> context = new HashMap<>();
        context.put("startTime", null);
        assertThrows(RuntimeException.class, ()-> {
            AnnotationUseRequiredContext annotationUseRequiredContext = new AnnotationUseRequiredContext(context);
        });

        context.put("endTime", null);
        assertDoesNotThrow(() -> {
            AnnotationUseRequiredContext annotationUseRequiredContext = new AnnotationUseRequiredContext(context);
        });
    }
}
