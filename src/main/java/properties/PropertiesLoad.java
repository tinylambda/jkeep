package properties;


import java.io.InputStream;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertiesLoad {
    private static final Properties hiveProperties = new Properties();

    private static void testLoad() {
        String propertiesFileName = "hive.properties";
        try (InputStream in = PropertiesLoad.class.getClassLoader().getResourceAsStream(propertiesFileName)) {
            hiveProperties.load(in);
        } catch (Exception e) {
            log.info("failed to load hive.properties: " + e);
        }
    }
    public static void main(String[] args) {
        log.info("size before loading: " + hiveProperties.size());
        testLoad();
        log.info("size after loading: " + hiveProperties.size());
    }
}
