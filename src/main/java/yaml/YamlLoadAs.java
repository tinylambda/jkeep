package yaml;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import lombok.extern.slf4j.Slf4j;
import yaml.classes.Line;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-26
 */
@Slf4j
public class YamlLoadAs {
    public static void main(String[] args) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("yaml/line.yaml");
        Yaml yaml = new Yaml();
        Line line = yaml.loadAs(inputStream, Line.class);
        log.info("{}", line);
    }
}
