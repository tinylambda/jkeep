package playground.basic;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newCopyOnWriteArrayList;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-19
 */
@Slf4j
public class BasicListElementRemove {
    public static void main(String[] args) {
        // use newArrayList will trigger ConcurrentModificationException
//        List<String> list = newArrayList("A", "B", "C");
        List<String> list = newCopyOnWriteArrayList(newArrayList("A", "B", "C"));

        for (String item : list) {
            if (item.equals("A")) {
                list.remove(item);
            }
        }

        log.info("{}", list);
    }
}
