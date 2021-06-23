package object;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectCompare
{
    public static void main(String[] args) {
        Integer x = 100;
        Integer y = 100;
        int z = 100;

        log.info("{}", x.equals(y));
        log.info("{}", x > y);
        log.info("{}", x == z);
    }
}
