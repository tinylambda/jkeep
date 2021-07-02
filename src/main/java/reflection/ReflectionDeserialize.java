package reflection;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionDeserialize {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        A a = new A();
        a.setX(2);
        a.setY(3);
        a.setTs(System.currentTimeMillis());

        String jsonString = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(a);
        log.info("super string: {}", jsonString);

        B b = OBJECT_MAPPER.readValue(jsonString, B.class);
        log.info("sub object from super string: {}", b);

        jsonString = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(b);
        log.info("sub string {}", jsonString);

        a = OBJECT_MAPPER.readValue(jsonString, A.class);
        log.info("super object from sub string: {}", a);

        jsonString = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(a);
        log.info("{}", jsonString);
    }
}
