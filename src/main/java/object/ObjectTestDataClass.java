package object;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ObjectTestDataClass {
    private String x;
    private String y;

    public String getX() {
        return x + "!";
    }

    public static void main(String[] args) {
        ObjectTestDataClass objectTestDataClass = new ObjectTestDataClass();
        objectTestDataClass.setX("hello");
        objectTestDataClass.setY("world");

        log.info(objectTestDataClass.getX());
        log.info(objectTestDataClass.getY());
    }
}
