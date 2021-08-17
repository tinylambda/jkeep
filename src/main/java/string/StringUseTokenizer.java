package string;

import java.util.StringTokenizer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUseTokenizer {
    public static void main(String[] args) {
        String s = "1001,1002,1003,1004";
        String delimiter = ",";
        StringTokenizer stringTokenizer = new StringTokenizer(s, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            log.info(token);
        }
    }
}
