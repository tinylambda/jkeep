package lang.features.interfaceinheritance;


public interface IT2 extends IT1 {
    Resource resourceWriter = new Resource("writer");

    @Override
    default Resource getResource() {
        return resourceWriter;
    }
}
