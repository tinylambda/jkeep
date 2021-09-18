package template.fstyle;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FStyleTry2 {
    public static void main(String[] args) {
        String text = "$xxx my name is $name, my age is $age, home is $address2, $name is '$$name' get_json_object(xx, '$.a')";
        Matcher matcher = Pattern.compile("\\$([a-zA-Z_0-9]+)").matcher(text);
        int i = 0;
        List<String> replaces = newArrayList();
        List<String> names = newArrayList();

        while (matcher.find()) {
            for (int j = 0; j <= matcher.groupCount(); j++) {
                String s = matcher.group(j);
                if (!StringUtils.startsWith(s, "$")) {
                    names.add(s);
                } else if (StringUtils.startsWith(s, "$")) {
                    replaces.add(s);
                }
                i++;
            }
        }

        log.info("{}, {}", replaces, names);
        checkArgument(CollectionUtils.size(replaces) == CollectionUtils.size(names));
        log.info("{} ==> {}", i, replaces);
        log.info("{} ==> {}", i, names);

        String template = text;
        for (String toBeReplaced : replaces) {
            template = StringUtils.replace(template, toBeReplaced, "%s");
        }
        log.info("{}", text);
        log.info("{}", template);

        Map<String, String> context = newHashMap();
        context.put("name", "felix");
        context.put("age", "18");
        context.put("address2", "shandong");

        String finalResult = String.format(template, names.stream().map(context::get).toArray());
        log.info(finalResult);
    }
}
