package enums;

import java.util.Map;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum EnumMethod {
    GOOD(1, "Hello"),
    NORMAL(2, "World"),
    BAD(3, "!"),
    ;

    private int id;
    private String desc;

    EnumMethod(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    private static Map<Integer, EnumMethod> idMap = new HashMap<>();
    static {
        for(EnumMethod method : EnumMethod.values()) {
            idMap.put(method.getId(), method);
        }
    }

    public static EnumMethod getById(int id) {
        return idMap.get(id);
    }

    public static void main(String[] args) {
        EnumMethod em = EnumMethod.GOOD;
        log.info("" + em.getId());
        log.info("" + EnumMethod.getById(em.getId()));
        log.info(EnumMethod.getById(2).toString());
    }
}
