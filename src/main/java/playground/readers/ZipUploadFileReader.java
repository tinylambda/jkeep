package playground.readers;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.annotation.Nullable;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-10-22
 */
@Slf4j
public class ZipUploadFileReader extends UploadFileReader {
    private static final String SAMPLE_FILE = "/tmp/test.zip";
    private static final Set<String> SKIP_PREFIXES = newHashSet("__MACOSX");
    private static final List<Charset> TRY_CODECS = newArrayList(StandardCharsets.UTF_8, Charset.forName("GBK"));

    private static final Predicate<ZipEntry> ZIP_FILTER = zipEntry -> {
        String name = zipEntry.getName();
        boolean skipName = SKIP_PREFIXES.stream().anyMatch(item -> StringUtils.startsWith(name, item));
        return !skipName && !zipEntry.isDirectory();
    };

    @Nullable
    @Override
    public BufferedReader createReader(String filename) {
        List<InputStream> inputStreams = newArrayList();
        try (ZipInputStream zipInputStream = TRY_CODECS.stream().map(codec -> {
            try {
                log.info("try {}", codec);
                return new ZipInputStream(new FileInputStream(filename), codec);
            } catch (Exception e) {
                return null;
            }
        }).filter(Objects::nonNull).findFirst().orElse(null)) {
            checkNotNull(zipInputStream, "");
            Optional<ZipFile> zipFile = Optional.of(new ZipFile(filename));
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (!ZIP_FILTER.test(zipEntry)) {
                    continue;
                }
                inputStreams.add(zipFile.get().getInputStream(zipEntry));
                inputStreams.add(new ByteArrayInputStream("\n".getBytes(StandardCharsets.UTF_8)));
            }
            return new BufferedReader(new InputStreamReader(new SequenceInputStream(Collections.enumeration(inputStreams)), StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.error("error creating zip reader", e);
        }
        return null;
    }

    @Override
    String getFileType() {
        return FilenameUtils.getExtension(SAMPLE_FILE);
    }
}
