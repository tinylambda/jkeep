package template.jinjava;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.hubspot.jinjava.Jinjava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JinjavaAccessObjectAttribute {

    static class Test {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        private String value;

        public Test(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        List<Test> list = new ArrayList<>();
        list.add(new Test("name1", "value1"));
        list.add(new Test("name2", "value2"));

        context.put("name", "felix");
        context.put("list", list);

        String template = "The length of list is {{ list.size() }} " +
                "{% if list.size() > 0 %} " +
                "{% for item in list %} {{ item.getName() }}='{{ item.getValue() }}' {% endfor %}" +
                "{% else %} " +
                "list is empty " +
                "{% endif %}";
        String rendered = jinjava.render(template, context);
        log.info(rendered);
    }
}
