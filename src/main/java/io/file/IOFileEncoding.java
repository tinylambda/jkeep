package io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-02
 */
@Slf4j
public class IOFileEncoding {
    public static void main(String[] args) throws Exception {
        String exampleString = "这是一个测试";
        File utf8File = File.createTempFile("helloUtf8", ".txt");
        File gbkFile = File.createTempFile("helloGbk", "txt");

        try (
                FileOutputStream utf8OutputStream = new FileOutputStream(utf8File.getAbsolutePath());
                FileOutputStream gbkOutputStream = new FileOutputStream(gbkFile.getAbsolutePath())
        ) {
            utf8OutputStream.write(exampleString.getBytes(StandardCharsets.UTF_8));
            gbkOutputStream.write(exampleString.getBytes("GBK"));
        }

        log.info("{}", EncodingUtils.getEncode(utf8File.getAbsolutePath(), true));
        log.info("{}", EncodingUtils.getEncode(gbkFile.getAbsolutePath(), true));


        File utf8FileTwo = File.createTempFile("helloUtf8Two", ".txt");
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(gbkFile.getAbsolutePath()), "GBK"));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(utf8FileTwo.getAbsolutePath()));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.append(line);
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(utf8FileTwo.getAbsolutePath())))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.info("line: {}", line);
            }
        }
    }
}
