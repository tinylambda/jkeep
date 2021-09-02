package string;


import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringFormat {
    public static void main(String[] args) throws Exception {
        String templateString = "Hello ${name} age is '${age}'";
        Template template = new Template("mytemplate", templateString, new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
        Map<String, String> map = new HashMap<>();
        map.put("name", "Felix");
        map.put("age", "25");

        StringWriter writer = new StringWriter();
        template.process(map, writer);
        log.info(writer.toString());

        String builtinFormat = String.format("hello %s", "中国人");
        log.info("{}", builtinFormat);
    }
}
