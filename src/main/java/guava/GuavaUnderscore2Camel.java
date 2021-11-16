package guava;

import com.google.common.base.CaseFormat;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-16
 */
@Slf4j
public class GuavaUnderscore2Camel {
    public static void main(String[] args) {
        String s = "UPLOAD_SERVICE";
        log.info("{}", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, s));
    }
}
