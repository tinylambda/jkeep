package json;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSONUnwrap {
    static class DataOne {
        public int getOneInt() {
            return 100;
        }

        public String getOneString() {
            return "oneString";
        }
    }

    static class DataTwo {
        public int getTwoInt() {
            return 200;
        }

        public String getTwoString() {
            return "twoString";
        }

        @JsonProperty("renamedKey")
        public int getOneInt() {
            return 100;
        }
    }

    static class UnwrapJson {
        private Map<String, String> map = newHashMap();

        public UnwrapJson() {
            add("x", "y");
            add("a", "b");
            add("m", "n");
        }

        @JsonAnySetter
        public void add(String key, String value) {
            map.put(key, value);
        }

        @JsonAnyGetter
        public Map<String, String> getMap() {
            return map;
        }

        @JsonUnwrapped
        public DataOne getDataOne() {
            return new DataOne();
        }

        @JsonUnwrapped
        public DataTwo getDataTwo() {
            return new DataTwo();
        }

        // JsonUnwrapped not work for map
        @JsonUnwrapped
        public Map<String, Object> getDataThree() {
            Map<String, Object> map = newHashMap();
            map.put("name", "Felix");
            map.put("list", newArrayList("x", "y", "z"));
            return map;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UnwrapJson unwrapJson = new UnwrapJson();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(unwrapJson);
        log.info(jsonString);
    }
}
