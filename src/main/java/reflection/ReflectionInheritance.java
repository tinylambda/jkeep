package reflection;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionInheritance {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Data
    static class Base {
        long value;
        long value2;
    }

    static class MyModel extends Base {
        @JsonIgnore
        @Override
        public long getValue() {
            return super.getValue() * 100;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        MyModel myModel = new MyModel();
        myModel.setValue(10);
        myModel.setValue2(20);
        log.info("{}", myModel.getValue());

        String jsonString = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(myModel);
        log.info(jsonString);

        MyModel myModel2 = OBJECT_MAPPER.readValue(jsonString, new TypeReference<MyModel>() {});
        log.info("{}", myModel2.getValue());

        String jsonString2 = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(myModel2);
        log.info(jsonString2);
    }

}
