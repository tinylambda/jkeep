package string;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringSplit2 {
    private static Set<Long> toLongSet(String s, String delimiter) {
        return Arrays.stream(s.split(delimiter))
                .filter(StringUtils::isNotEmpty)
                .map(NumberUtils::toLong)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        String s = "1001,1002,1003,1004";
        String delimiter = ",";
        log.info("{}", toLongSet(s, delimiter));

        s = "";
        log.info("{}", toLongSet(s, delimiter));
    }
}
