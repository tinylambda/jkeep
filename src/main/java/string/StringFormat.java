package string;


import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class StringFormat {
    public static void main(String[] args) throws Exception {
        String templateString = "Hello ${name} age is '${age}'";
        Template template = new Template("mytemplate", templateString, new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
        Map<String, String> map = new HashMap<>();
        map.put("name", "Felix");
        map.put("age", "25");

        StringWriter writer = new StringWriter();
//        System.out.println(template.getName());
        template.process(map, writer);
        System.out.println(writer.toString());
    }
}
