package spi;


import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<ISearch> serviceLoader = ServiceLoader.load(ISearch.class);
        for (ISearch search : serviceLoader) {
            search.search("this is cool");
        }
    }
}
