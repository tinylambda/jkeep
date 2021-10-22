package io.file;

import org.apache.commons.io.FilenameUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public class IOFileGetExtension {
    public static void main(String[] args) {
        String filename = "hello.txt";
        String ext = FilenameUtils.getExtension(filename);
        log.info("{}", ext);
    }
}
