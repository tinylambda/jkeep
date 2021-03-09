package enums;


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
        System.out.println(this.possibilities);
        System.out.println(POSSIBILITIES.valueOf("BAD"));

        System.out.println("print all possibilities");
        for(POSSIBILITIES possibilities: POSSIBILITIES.values()) {
            System.out.println(possibilities);
        }
    }

    public static void main(String[] args) {
        EnumSimple enumSimple = new EnumSimple(POSSIBILITIES.GOOD);
        enumSimple.showPossibilityValue();
    }
}
