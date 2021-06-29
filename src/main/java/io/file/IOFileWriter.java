package io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOFileWriter {
    private static final String FILENAME = "/tmp/test.log";
    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            writer.append("gogogo");
            writer.newLine();
            writer.append("gogogogogogo");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            reader.lines().forEach(log::info);
        }
    }
}
