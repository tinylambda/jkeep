package string;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringSplit {
    public static void main(String[] args) {
        String s = "select * from table;";
        String[] parts = s.split(";");
        log.info("result is {}, len is {}", parts, parts.length);

        s = "select * from table; ";
        parts = s.split(";");
        log.info("result is {}, len is {}", parts, parts.length);

        s = "select * from table";
        parts = s.split(";");
        log.info("result is {}, len is {}", parts, parts.length);

        s = "";
        parts = s.split(";");
        log.info("result is {}, len is {}", parts, parts.length);
        log.info(parts[0]);
    }
}
