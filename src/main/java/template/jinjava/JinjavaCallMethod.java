package template.jinjava;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.interpret.TemplateSyntaxException;
import com.hubspot.jinjava.interpret.UnknownTokenException;
import com.hubspot.jinjava.lib.filter.Filter;
import com.hubspot.jinjava.lib.tag.Tag;
import com.hubspot.jinjava.tree.TagNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JinjavaCallMethod {
    public static void main(String[] args) {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        List<JinjavaAccessObjectAttribute.Test> list = new ArrayList<>();
        list.add(new JinjavaAccessObjectAttribute.Test("name1", "value1"));
        list.add(new JinjavaAccessObjectAttribute.Test("name2", "value2"));

        context.put("x", 1);
        context.put("y", 2);
        context.put("z", 3);
        context.put("name", "x");
        context.put("list", list);

        Map<String, Object> newContext = new HashMap<>(context);
        newContext.put("context", context);

        String template = "The length of list is {{ list.size() }} " +
                "{% if list.size() > 0 %} " +
                "{% for item in list %} {{ item.getName() }}='{{ item.getValue() }}' {% endfor %}" +
                "{% else %} " +
                "list is empty " +
                "{% endif %}";
        String rendered = jinjava.render(template, context);
        log.info(rendered);

        jinjava.getGlobalContext().registerFilter(new Filter() {
            @Override
            public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
                log.info("interpreter context is {}", interpreter.getContext().get("name"));
                Object result = interpreter.getContext().get(args[0]);
                log.info("result is {}", result);
                if (result == null) {
                    throw new UnknownTokenException(args[0], interpreter.getLineNumber(), interpreter.getPosition());
                }
                return interpreter.getContext().get(args[0]);
            }

            @Override
            public String getName() {
                return "get_key";
            }
        });

        template = "my name is {{ '' | get_key(name) }}";
        rendered = jinjava.render(template, newContext);
        log.info(rendered);
    }
}
