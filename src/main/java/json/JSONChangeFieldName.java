package json;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONChangeFieldName {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty("coolAddress")
    private String address;
    @JsonProperty
    private String extra = null;

    public static void main(String[] args) {
        JSONChangeFieldName jsonChangeFieldName = new JSONChangeFieldName();
        jsonChangeFieldName.setId(100001);
        jsonChangeFieldName.setName("felix");
        jsonChangeFieldName.setAddress("address for me");

        ObjectMapper objectMapper = new ObjectMapper();
        Map mapFromObject = objectMapper.convertValue(jsonChangeFieldName, Map.class);
        log.info(mapFromObject.toString());
    }
}
