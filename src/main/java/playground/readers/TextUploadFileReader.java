package playground.readers;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.io.FilenameUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public class TextUploadFileReader extends UploadFileReader {
    private static final String SAMPLE_FILE = "/tmp/test.txt";

    @Nullable
    @Override
    public BufferedReader createReader(@Nonnull String filename) {
        try {
            checkNotNull(filename, "filename should not be null");
            return new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            log.error("error creating text reader", e);
        }
        return null;
    }

    @Override
    String getFileType() {
        return FilenameUtils.getExtension(SAMPLE_FILE);
    }
}
