package io.file;


import java.nio.file.Path;
import java.nio.file.Paths;

public class IOFilePath {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"));
        System.out.println(path.toString());
        System.out.println(path.toAbsolutePath());

        path = Paths.get("tmp/", "a", "b", "c");
        System.out.println(path.toString());
        System.out.println(path.toAbsolutePath());
    }
}
