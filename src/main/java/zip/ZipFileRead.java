package zip;

import static com.google.common.collect.Lists.newArrayList;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public class ZipFileRead {
    private static final String ZIP_FILE_PATH = "/tmp/test.zip";

    public static void main(String[] args) {
        try (
                ZipFile zipFile = new ZipFile(ZIP_FILE_PATH);
                ZipInputStream zipInputStream=new ZipInputStream(new FileInputStream(ZIP_FILE_PATH), StandardCharsets.UTF_8)) {
            ZipEntry zipEntry;
            List<InputStream> inputStreams = newArrayList();

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String filename = zipEntry.getName();

                boolean skipFile = zipEntry.isDirectory() || StringUtils.startsWith(filename, "__MACOSX");
                if (skipFile) {
                    continue;
                }

                String ext = FilenameUtils.getExtension(filename);
                if (StringUtils.equals("txt", ext)) {
                    inputStreams.add(zipFile.getInputStream(zipEntry));
                    inputStreams.add(new ByteArrayInputStream("\n".getBytes(StandardCharsets.UTF_8)));
                }
            }

            SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(inputStreams));

            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sequenceInputStream, StandardCharsets.UTF_8))) {
                bufferedReader.lines().filter(StringUtils::isNotBlank).forEach(log::info);
            }
        } catch (IOException e) {
            log.error("something goes wrong", e);
        }
    }
}
