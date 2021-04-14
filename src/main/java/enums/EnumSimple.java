package enums;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumSimple {
    enum POSSIBILITIES {
        GOOD,
        BAD,
        NOTHING,
    }

    private POSSIBILITIES possibilities;
    public EnumSimple(POSSIBILITIES possibilities) {
        this.possibilities = possibilities;
    }

    public void showPossibilityValue() {
        log.info("" + this.possibilities);
        log.info("" + POSSIBILITIES.valueOf("BAD"));

        log.info("print all possibilities");
        for(POSSIBILITIES possibilities: POSSIBILITIES.values()) {
            log.info("" + possibilities);
        }
    }

    public static void main(String[] args) {
        EnumSimple enumSimple = new EnumSimple(POSSIBILITIES.GOOD);
        enumSimple.showPossibilityValue();
    }
}
