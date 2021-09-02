package io.file;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import com.google.common.base.Splitter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOFileReadCSV {
    static String csvFileOne = "/Users/felix/Downloads/test/test1.csv";
    static String csvFileTwo = "/Users/felix/Downloads/test/test2.csv";
    static String csvFileThree = "/Users/felix/Downloads/test/test3.csv";

    Splitter splitter = Splitter.on(",");

    public void testIt(String fileName) throws Exception {
        BufferedReader readerOne = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = readerOne.readLine()) != null) {
            List<String> items = splitter.splitToList(line);
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws Exception {
        IOFileReadCSV ioFileReadCSV = new IOFileReadCSV();
        ioFileReadCSV.testIt(csvFileOne);
        log.info("\n------------------\n");
        ioFileReadCSV.testIt(csvFileTwo);
        log.info("\n------------------\n");
        ioFileReadCSV.testIt(csvFileThree);
    }
}
