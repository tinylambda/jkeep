package collections.list;


import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListArrayListToString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello ");
        list.add("world ");
        list.add("!");
        log.info(
                list.toString()
        );
    }
}
