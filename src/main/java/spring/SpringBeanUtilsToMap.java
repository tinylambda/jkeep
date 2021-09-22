package spring;


import static com.google.common.collect.Lists.newArrayList;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringBeanUtilsToMap {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        DataClass felix = new DataClass("felix", 20, "male");

        List<String> interestedProperties = newArrayList("name", "age");
        List<String> values = interestedProperties.stream().map(propName -> {
            try {
                return BeanUtils.getProperty(felix, propName);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                log.debug("error", e);
            }
            return null;
        }).collect(Collectors.toList());

        log.info("{}", values);
    }
}
