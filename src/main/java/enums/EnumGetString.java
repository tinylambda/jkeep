package enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum EnumGetString {
    A,
    B,
    C,
    D
    ;

    EnumGetString() {}

    public static void main(String[] args) {
        EnumGetString sample = EnumGetString.C;
        log.info(sample.toString());
        log.info(sample.name());
        log.info("" + sample.ordinal());
    }
}
