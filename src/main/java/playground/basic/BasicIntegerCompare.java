package playground.basic;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-19
 */
public class BasicIntegerCompare {
    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;

        Integer c = 10;
        Integer d = 10;

        System.out.println(a.equals(b));  // true
        System.out.println(a == b);  // false

        System.out.println(a.compareTo(b)); // 0
        System.out.println(b.compareTo(a)); // 0

        System.out.println(c == d);  // true
    }
}
