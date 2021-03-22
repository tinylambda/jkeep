package string;


import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class StringLength {
    public static void main(String[] args) throws Exception {
        String testString = "Hello world";
        System.out.println(testString.length());

        String hashedString = Hashing.md5().hashString(testString, StandardCharsets.UTF_8).toString();
        System.out.println(hashedString);
        System.out.println(hashedString.length());
    }
}
