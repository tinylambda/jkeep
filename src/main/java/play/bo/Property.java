package play.bo;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import play.bo.DataType;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Property {
    private String name;
    private String desc;
    private DataType dataType;
    private String is;
    private Map<String, String> meta;

    public static Property of(String propName, String propDesc, DataType propDataType, String propIs) {
        return new Property(propName, propDesc, propDataType, propIs, newHashMap());
    }

    public static Property of(String propName, String propDesc, DataType propDataType) {
        return of(propName, propDesc, propDataType, null);
    }
}
