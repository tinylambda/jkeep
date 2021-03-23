package io.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOFileReadLine {
    public static void main(String[] args) throws Exception {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src/main/java/io.file", "FileReadLine.java");
        System.out.println("input io.file is " + filePath.toString());
        FileInputStream fileInputStream = new FileInputStream(filePath.toString());
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.print(line);
        }
    }
}
