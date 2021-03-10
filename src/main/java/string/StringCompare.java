package string;


public class StringCompare {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "Hello";
        String s3 = "world";
        System.out.println(s1.compareTo(s1));
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareToIgnoreCase(s2));
        System.out.println(s1.compareTo(s3));
    }
}
