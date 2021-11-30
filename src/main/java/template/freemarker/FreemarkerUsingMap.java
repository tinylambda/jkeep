package template.freemarker;

import static com.google.common.collect.Maps.newHashMap;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.io.output.StringBuilderWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-30
 */
@Slf4j
public class FreemarkerUsingMap {
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_31);
    static {
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setLogTemplateExceptions(true);
        CONFIGURATION.setWrapUncheckedExceptions(true);
        CONFIGURATION.setWhitespaceStripping(true);
    }

    private final Template template;

    private FreemarkerUsingMap(String content) throws IOException {
        this.template = new Template(null, content, CONFIGURATION);
    }

    public static FreemarkerUsingMap of(String content) throws IOException {
        return new FreemarkerUsingMap(content);
    }

    @SneakyThrows
    public String render(Map<String, Object> context) {
        try (Writer out = new StringBuilderWriter()) {
            template.process(context, out);
            return out.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        Map<String, Object> context = newHashMap();
        context.put("x", 100);
        context.put("y", 200);
        FreemarkerUsingMap freemarkerUsingMap = FreemarkerUsingMap.of("x: ${x?c}, y: ${y}");
        log.info("{}", freemarkerUsingMap.render(context));

        context.clear();
        context.put("x", 1000);
        context.put("y", 1000);
        log.info("{}", freemarkerUsingMap.render(context));
    }
}
