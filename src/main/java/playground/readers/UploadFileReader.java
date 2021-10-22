package playground.readers;

import java.io.BufferedReader;
import java.io.Closeable;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public abstract class UploadFileReader {
    {
        ReaderFactory.REGISTRY.put(getFileType(), this);
    }

    abstract BufferedReader createReader(String filename);
    abstract String getFileType();
}
