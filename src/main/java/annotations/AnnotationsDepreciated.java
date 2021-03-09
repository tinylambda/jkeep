package annotations;

public class AnnotationsDepreciated {
    static class Inner {
        @Deprecated
        public void doSomething() {
            System.out.println("do something");
        }
    }

    private final Inner inner;

    public AnnotationsDepreciated(Inner inner) {
        this.inner = inner;
    }

    public void test() {
        // IDE will tip it's depreciated
        this.inner.doSomething();
    }

    public static void main(String[] args) {
        AnnotationsDepreciated annotationsDepreciated = new AnnotationsDepreciated(new Inner());
        annotationsDepreciated.test();
    }
}
