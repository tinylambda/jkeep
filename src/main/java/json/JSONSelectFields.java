package json;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class JSONSelectFields {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;

    @JsonIgnore
    private String address;

    public static void main(String[] args) {
        JSONSelectFields jsonSelectFields = new JSONSelectFields();
        jsonSelectFields.setId(100001);
        jsonSelectFields.setName("felix");
        jsonSelectFields.setAddress("good address");

        ObjectMapper objectMapper = new ObjectMapper();

        Map map = objectMapper.convertValue(jsonSelectFields, Map.class);
        log.info(map.toString());
    }
}
