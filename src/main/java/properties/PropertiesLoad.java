package properties;


import java.io.InputStream;
import java.util.Properties;


public class PropertiesLoad {
    private static final Properties hiveProperties = new Properties();

    private static void testLoad() {
        String propertiesFileName = "hive.properties";
        try (InputStream in = PropertiesLoad.class.getClassLoader().getResourceAsStream(propertiesFileName)) {
            hiveProperties.load(in);
        } catch (Exception e) {
            System.out.println("failed to load hive.properties: " + e);
        }
    }
    public static void main(String[] args) {
        System.out.println("size before loading: " + hiveProperties.size());
        testLoad();
        System.out.println("size after loading: " + hiveProperties.size());
    }
}
