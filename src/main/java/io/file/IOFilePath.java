package io.file;


import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOFilePath {
    public static void main(String[] args) {
        Path path = Paths.get(System.getProperty("user.dir"));
        log.info(path.toString());
        log.info(path.toAbsolutePath().toString());

        path = Paths.get("tmp/", "a", "b", "c");
        log.info(path.toString());
        log.info(path.toAbsolutePath().toString());
    }
}
