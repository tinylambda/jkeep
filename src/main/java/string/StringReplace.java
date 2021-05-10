package string;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringReplace {
    public static void main(String[] args) {
        String origin = "--- gogo\n" +
                "upup\n" +
                "\n" +
                "antoher line\n" +
                "line again";
        log.info(origin);

        log.info("\n\tafter replace blank lines:\n");

        String origin2 = origin.replaceAll("(?m)^[ \t]*\r?\n", "");
        log.info(origin2);

    }
}
