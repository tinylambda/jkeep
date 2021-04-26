package template.jinjava;


import java.util.Map;

import com.google.common.collect.Maps;
import com.hubspot.jinjava.Jinjava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JinjavaRenderString {
    public static void main(String[] args) {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("name", "felix");
        String template = "Hello {{ name }}! Your name {{ name }} is cool !";
        String rendered = jinjava.render(template, context);
        log.info(rendered);
    }
}
