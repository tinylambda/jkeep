package object;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectDefaultValue {
    static class Test {}

    private int x;
    private float y;
    private double z;
    private boolean b;

    private String s;
    private Integer xx;
    private Float yy;
    private Double zz;
    private Boolean bb;

    private Test tt;

    public static void main(String[] args) {
        ObjectDefaultValue defaultValue = new ObjectDefaultValue();
        log.info("{}", defaultValue.x);
        log.info("{}", defaultValue.y);
        log.info("{}", defaultValue.z);
        log.info("{}", defaultValue.b);

        log.info("{}", defaultValue.s);
        log.info("{}", defaultValue.xx);
        log.info("{}", defaultValue.yy);
        log.info("{}", defaultValue.zz);
        log.info("{}", defaultValue.bb);
        log.info("{}", defaultValue.tt);
    }
}
