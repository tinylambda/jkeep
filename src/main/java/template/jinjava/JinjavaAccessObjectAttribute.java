package template.jinjava;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.hubspot.jinjava.Jinjava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JinjavaAccessObjectAttribute {
    public static void main(String[] args) {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        List<String> list = new ArrayList<>();
        list.add("hi");

        context.put("name", "felix");
        context.put("list", list);

        String template = "The length of list is {{ list.size() }} {% if list.size() > 0 %} got list! {% else %} list is empty {% endif %}";
        String rendered = jinjava.render(template, context);
        log.info(rendered);
    }
}
