package annotation;

public class AnnotationDepreciated {
    static class Inner {
        @Deprecated
        public void doSomething() {
            System.out.println("do something");
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
