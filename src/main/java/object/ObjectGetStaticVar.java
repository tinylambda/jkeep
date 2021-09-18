package object;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectGetStaticVar {
    public static final String TEST_VAR = "an var";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        log.info("{}", ObjectGetStaticVar.class.newInstance().TEST_VAR);
    }
}
