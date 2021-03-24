package io.file;


import java.net.URI;

public class IOURLPath {
    public static void main(String[] args) throws Exception {
        String hdfsRoot = "hdfs://example.com/";
        String storagePath = "/home/felix/data/biz_101_data/";

        URI uri = new URI(hdfsRoot);
        System.out.println(uri.resolve(storagePath));

        storagePath = "/home/felix/data/biz_101_data/";
        System.out.println(uri.resolve(storagePath));
    }
}
