package template.jinjava;

import java.util.ArrayList;
import java.util.Map;

import com.google.common.collect.Maps;
import com.hubspot.jinjava.Jinjava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JinjavaJoinFilter {
    public static void main(String[] args) {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        context.put("list", list);
        String template = "{{ list|join(',') }}";
        String rendered = jinjava.render(template, context);
        log.info(rendered);
    }
}
