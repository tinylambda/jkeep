package template.freemarker;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.io.output.StringBuilderWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-30
 */
@Slf4j
public class FreemarkerSimple {
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_31);
    static {
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setLogTemplateExceptions(true);
        CONFIGURATION.setWrapUncheckedExceptions(true);
        CONFIGURATION.setWhitespaceStripping(true);
    }

    private final Template template;

    private FreemarkerSimple(String content) throws IOException {
        this.template = new Template(null, content, CONFIGURATION);
    }

    public static FreemarkerSimple of(String content) throws IOException {
        return new FreemarkerSimple(content);
    }

    @SneakyThrows
    public String render(FreemarkerSimpleContext context) {
        try (Writer out = new StringBuilderWriter()) {
            template.process(context, out);
            return out.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        FreemarkerSimpleContext freemarkerSimpleContext = new FreemarkerSimpleContext(100, 200);
        FreemarkerSimple freemarkerSimple = FreemarkerSimple.of("x: ${x}, y: ${y}");
        log.info("{}", freemarkerSimple.render(freemarkerSimpleContext));
    }
}
