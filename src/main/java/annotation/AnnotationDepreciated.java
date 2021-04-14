package annotation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnnotationDepreciated {
    static class Inner {
        @Deprecated
        public void doSomething() {
            log.info("do something");
        }
    }

    private final Inner inner;

    public AnnotationDepreciated(Inner inner) {
        this.inner = inner;
    }

    public void test() {
        // IDE will tip it's depreciated
        this.inner.doSomething();
    }

    public static void main(String[] args) {
        AnnotationDepreciated annotationDepreciated = new AnnotationDepreciated(new Inner());
        annotationDepreciated.test();
    }
}
