package play.bo;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class BusinessObject {
    private String name;
    private String desc;
    private Map<String, Property> propertyMap;
    private Map<String, String> meta;

    public Property getProperty(String propName) {
        return propertyMap.get(propName);
    }

    public String getPropertyFullName(String propName) {
        Property property = propertyMap.get(propName);
        return String.format("%s.%s", name, property.getName());
    }

    public void addProperty(Property property) {
        propertyMap.put(property.getName(), property);
    }

    public static BusinessObject of(String name, String desc) {
        return new BusinessObject(name, desc, newHashMap(), newHashMap());
    }
}
