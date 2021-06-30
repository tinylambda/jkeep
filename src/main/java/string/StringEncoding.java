package string;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringEncoding {
    public static void main(String[] args) {
        String s = "微笑哥\uD83C\uDD94:6️";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        log.info("{}", bytes);
        log.info(Normalizer.normalize(s, Normalizer.Form.NFC));
        log.info(Normalizer.normalize(s, Normalizer.Form.NFD));
        log.info(Normalizer.normalize(s, Normalizer.Form.NFKC));
        log.info(Normalizer.normalize(s, Normalizer.Form.NFKD));
    }
}
