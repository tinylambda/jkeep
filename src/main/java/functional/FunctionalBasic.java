package functional;

import java.util.ArrayList;
import java.util.List;

public class FunctionalBasic {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list.add(i);
        }

        list.stream()
                .filter(item -> item % 2 == 0)
                .forEach(System.out::println);
    }
}
