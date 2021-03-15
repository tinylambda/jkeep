package collections.list;


import java.util.ArrayList;
import java.util.List;

public class ListArrayListToString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello ");
        list.add("world ");
        list.add("!");
        System.out.println(
                list.toString()
        );
    }
}
