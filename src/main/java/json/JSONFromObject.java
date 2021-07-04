package json;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class JSONFromObject {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String address;

    public static void main(String[] args) throws JsonProcessingException {
        JSONFromObject jsonFromObject = new JSONFromObject();
        jsonFromObject.setId(100001);
        jsonFromObject.setName("felix");
        jsonFromObject.setAddress("address for me");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonFromObject);
        log.info(jsonString);

        Map<String, Object> map;
        map = objectMapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {});
        log.info(map.toString());
        log.info(map.get("id").toString());
        log.info(map.get("name").toString());
        log.info(map.get("address").toString());
    }
}
