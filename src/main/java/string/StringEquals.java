package string;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringEquals {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "是";
        String s4 = "是";

        log.info("{}", StringUtils.equals(s1, s2));
        log.info("{}", StringUtils.equals(s3, s4));
    }
}
