package playground.readers;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Maps.newHashMap;

import java.io.BufferedReader;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.commons.io.FilenameUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public class ReaderFactory {
    public static final Map<String, UploadFileReader> REGISTRY = newHashMap();

    static {
        new TextUploadFileReader();
        new ZipUploadFileReader();
    }

    @Nonnull
    static BufferedReader getBufferedReader(String path) {
        String ext = getFileExtension(path);
        UploadFileReader reader = REGISTRY.get(ext);
        checkNotNull(reader, "没有此文件对应的读取器：" + path);
        return REGISTRY.get(ext).createReader(path);
    }

    @Nonnull
    private static String getFileExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }
}
