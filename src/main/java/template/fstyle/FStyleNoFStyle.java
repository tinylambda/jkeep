package template.fstyle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FStyleNoFStyle {
    public static void main(String[] args) {
        String template = "hello %s";
        log.info(String.format(template, "world"));
    }
}
