package yaml;


import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YamlRead {
    public static void main(String[] args) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("yaml/test.yaml");
        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            log.info("{} => {}", entry.getKey(), entry.getValue());
            Map<String, Object> item = (Map<String, Object>) entry.getValue();
            for (Map.Entry<String, Object> entry1: item.entrySet()) {
                log.info("\t{} ==> {}", entry1.getKey(), entry1.getValue());
            }
        }
    }
}
