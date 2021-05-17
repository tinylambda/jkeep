package lang.features.interfaceinheritance;


public interface IT1 {
    Resource resourceReader = new Resource("reader");

    default Resource getResource() {
        return resourceReader;
    }

    default void test() {
        System.out.println(getResource());
    }
}
