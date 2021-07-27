package object;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectDefaultValue {
    private int x;
    private float y;
    private double z;
    private boolean b;
    private String s;

    public static void main(String[] args) {
        ObjectDefaultValue defaultValue = new ObjectDefaultValue();
        log.info("{}", defaultValue.x);
        log.info("{}", defaultValue.y);
        log.info("{}", defaultValue.z);
        log.info("{}", defaultValue.b);
        log.info("{}", defaultValue.s);
    }
}
