package io.stream;


import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.apache.hadoop.io.IOUtils;

public class StreamByteArrayInputStream {
    public static void main(String[] args) throws Exception {
        OutputStream outputStream = new FileOutputStream("/tmp/test.data");
        InputStream inputStream = new ByteArrayInputStream("Hello world.".getBytes(StandardCharsets.UTF_8));
        IOUtils.copyBytes(inputStream, outputStream, 64, true);
    }
}
