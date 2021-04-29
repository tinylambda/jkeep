package statictest;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String[] args) {
        log.info(Meta.A.x);
        log.info(Meta.B.y);
        log.info(Meta.C.x);
    }
}
