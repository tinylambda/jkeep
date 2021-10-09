package template.fstyle;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Objects.nonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FStyleFinal {
    private static final String PLACEHOLDERS_KEY = "placeholders";
    private static final String VARIABLE_NAMES_KEY = "variableNames";
    private static final String PLACEHOLDER_PREFIX = "{{";
    private static final String PLACEHOLDER_SUFFIX = "}}";
    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{\\{\\s*([\\S]+)\\s*}}");

    private static Map<String, List<String>> toPlaceholdersAndVariableNames(String rawTemplate) {
        List<String> placeholders = newArrayList();
        List<String> variableNames = newArrayList();

        Matcher matcher = PLACEHOLDER_PATTERN.matcher(rawTemplate);
        while (matcher.find()) {
            for (int j = 0; j <= matcher.groupCount(); j++) {
                String s = matcher.group(j);
                if (StringUtils.startsWith(s, PLACEHOLDER_PREFIX) && StringUtils.endsWith(s, PLACEHOLDER_SUFFIX)) {
                    placeholders.add(s);
                } else if (!StringUtils.startsWith(s, PLACEHOLDER_PREFIX) && !StringUtils.endsWith(s, PLACEHOLDER_SUFFIX)) {
                    variableNames.add(s);
                }
            }
        }
        checkArgument(CollectionUtils.size(placeholders) == CollectionUtils.size(variableNames), "template engine error");

        Map<String, List<String>> map = newHashMap();
        map.put(PLACEHOLDERS_KEY, placeholders);
        map.put(VARIABLE_NAMES_KEY, variableNames);
        return map;
    }

    private static String toJavaTemplate(String rawTemplate, List<String> placeholders) {
        String javaTemplate = rawTemplate;
        for (String placeholder : placeholders) {
            javaTemplate = StringUtils.replaceOnce(javaTemplate, placeholder, "%s");
        }
        return javaTemplate;
    }

    private static Object[] toJavaTemplateRenderValues(Map<String, String> context, List<String> variableNames, boolean allowNull) {
        return variableNames.stream().map(name -> {
            String value = context.get(name);
            if (!allowNull) {
                checkArgument(nonNull(value), name + " should not be null");
            }
            return value;
        }).toArray();
    }

    private static Map<String, String> fromBeanToMap(Object bean, List<String> variableNames) {
        return variableNames.stream().distinct().map(name -> {
            String value = null;
            try {
                value = BeanUtils.getProperty(bean, name);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                log.debug("fromBeanToMap error", e);
            }
            return Pair.of(name, value);
        }).filter(p -> nonNull(p.getRight())).collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
    }

    public static String render(String rawTemplate, Map<String, String> context, boolean allowNull) {
        Map<String, List<String>> templateMeta = toPlaceholdersAndVariableNames(rawTemplate);
        List<String> placeholders = templateMeta.get(PLACEHOLDERS_KEY);
        List<String> variableNames = templateMeta.get(VARIABLE_NAMES_KEY);
        // transform template to java style template
        String javaTemplate = toJavaTemplate(rawTemplate, placeholders);
        Object[] renderValues = toJavaTemplateRenderValues(context, variableNames, allowNull);
        return String.format(javaTemplate, renderValues);
    }

    public static String render(String rawTemplate, Object bean, boolean allowNull) {
        Map<String, List<String>> templateMeta = toPlaceholdersAndVariableNames(rawTemplate);
        List<String> variableNames = templateMeta.get(VARIABLE_NAMES_KEY);
        Map<String, String> mapContext = fromBeanToMap(bean, variableNames);
        return render(rawTemplate, mapContext, allowNull);
    }

    public static void main(String[] args) {
        String template = "hello, my name is {{ name }}, and I am  {{age}} years old, a null value {{ not_exists }}";
        Map<String, String> context = newHashMap();
        context.put("name", "felix");
        context.put("age", "18");
        String s = render(template, context, true);
        log.info("{}", s);

        try {
            render(template, context, false);
        } catch (IllegalArgumentException e) {
            log.error("error", e);
        }
    }
}
