package io.file;


import java.net.URI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOURLPath {
    public static void main(String[] args) throws Exception {
        String hdfsRoot = "hdfs://example.com/";
        String storagePath = "/home/felix/data/biz_101_data/";

        URI uri = new URI(hdfsRoot);
        log.info(uri.resolve(storagePath).toString());

        storagePath = "/home/felix/data/biz_101_data/";
        log.info(uri.resolve(storagePath).toString());
    }
}
