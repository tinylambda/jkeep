package io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-25
 */
@Slf4j
public class IOCreateTempFile {
    public static void main(String[] args) throws IOException {
        File file = File.createTempFile("hello", ".txt");
        log.info("{}", file.getAbsolutePath());
        Files.delete(file.toPath());
    }
}
