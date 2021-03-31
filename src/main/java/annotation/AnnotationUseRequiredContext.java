package annotation;

import java.util.Map;

import org.junit.platform.commons.annotation.Testable;

import lombok.extern.slf4j.Slf4j;

@AnnotationRequiredContext(requiredContextNames = {"startTime", "endTime"})
@Slf4j
@Testable
public class AnnotationUseRequiredContext {
    private Map<String, Object> context;

    public AnnotationUseRequiredContext(Map<String, Object> context) {
        AnnotationRequiredContext annotation = getClass().getAnnotation(AnnotationRequiredContext.class);
        String[] requiredContextNames = annotation.requiredContextNames();
        for (String name : requiredContextNames) {
            if (!context.containsKey(name)) {
                throw new RuntimeException("AnnotationUseRequiredContext need context specified for " + name + " but not specified in context");
            }
        }
        this.context = context;
    }

}
