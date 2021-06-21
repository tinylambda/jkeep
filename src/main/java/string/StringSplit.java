package string;

import com.google.common.base.Splitter;

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

        Splitter splitter = Splitter.on("_").trimResults();
        s = "hello_world_this_is_good";
        for(String item : splitter.split(s)) {
            log.info(":: {}", item);
        }
    }
}
