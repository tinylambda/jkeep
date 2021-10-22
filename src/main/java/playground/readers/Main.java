package playground.readers;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public class Main {
    private static final String SAMPLE_ZIP_FILE = "/tmp/test.zip";
    private static final String SAMPLE_TXT_FILE = "/tmp/test.txt";

    public static void main(String[] args) throws IOException {
        log.info("reading text");
        try (BufferedReader reader = ReaderFactory.getBufferedReader(SAMPLE_TXT_FILE)) {
            reader.lines().filter(StringUtils::isNotBlank).forEach(log::info);
        }

        log.info("reading zip");
        try (BufferedReader reader = ReaderFactory.getBufferedReader(SAMPLE_ZIP_FILE)) {
            reader.lines().filter(StringUtils::isNotBlank).forEach(log::info);
        }
    }
}
