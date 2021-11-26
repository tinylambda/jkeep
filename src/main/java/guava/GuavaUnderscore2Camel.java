package guava;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

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

        // replace number with _number
        s = "orientation1";
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(s);
        List<String> placeholders = newArrayList();
        List<String> variableNames = newArrayList();
        while (matcher.find()) {
            placeholders.add(matcher.group(0));
            variableNames.add(matcher.group(1));
        }
        for (int i = 0; i < placeholders.size(); i++) {
            s = StringUtils.replaceOnce(s, placeholders.get(i), "_" + variableNames.get(i));
        }
        log.info("{}", s);
    }
}
