package template.jinjava;

import java.util.HashMap;
import java.util.Map;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.JinjavaConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JinjavaConfigFailIfTokenUnknown {
    public static void main(String[] args) {
        JinjavaConfig.Builder jinJavaConfigBuilder = JinjavaConfig.newBuilder();
        jinJavaConfigBuilder.withFailOnUnknownTokens(true);
        JinjavaConfig jinjavaConfig = jinJavaConfigBuilder.build();
        Jinjava jinjava = new Jinjava(jinjavaConfig);

        String template = "Hello {{ name }} with a {{ unknown }} field";
        Map<String, Object> context = new HashMap<>();
        context.put("name", "Felix");
        context.put("unknown", "good");  // comment out this line to trigger UnknownToken Exception
        String result = jinjava.render(template, context);  // if not provide value for unknown, will fail
        log.info(result);
    }
}
