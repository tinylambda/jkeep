package collections.list;


import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-13
 */
@Slf4j
public class ListSubList {
    public static void main(String[] args) {
        List<String> myList = newArrayList("hello");
        log.info("{}", myList.subList(1, 1));
    }
}
