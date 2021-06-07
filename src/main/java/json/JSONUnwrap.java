package json;

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

        public int getOneInt() {
            return 100;
        }
    }

    static class UnwrapJson {
        @JsonUnwrapped
        public DataOne getDataOne() {
            return new DataOne();
        }

        @JsonUnwrapped
        public DataTwo getDataTwo() {
            return new DataTwo();
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UnwrapJson unwrapJson = new UnwrapJson();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(unwrapJson);
        log.info(jsonString);
    }
}
