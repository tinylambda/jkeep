package json;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONExcludeNullFields {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String address;
    @JsonProperty
    private String extra = null;

    public static void main(String[] args) throws JsonProcessingException {
        JSONFromObject jsonFromObject = new JSONFromObject();
        jsonFromObject.setName("felix");
        jsonFromObject.setAddress("good address");
        jsonFromObject.setId(10001);

        ObjectMapper objectMapper = new ObjectMapper();

        Map mapFromObject = objectMapper.convertValue(jsonFromObject, Map.class);
        log.info(mapFromObject.toString());
    }
}
