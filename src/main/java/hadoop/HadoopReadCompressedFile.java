package hadoop;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import javax.annotation.Nullable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HadoopReadCompressedFile {
    public static void main(String[] args) throws Exception {
        String uri = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);

        Path path = new Path(uri);
        CompressionCodecFactory codecFactory = new CompressionCodecFactory(conf);
        @Nullable CompressionCodec compressionCodec = codecFactory.getCodec(path);
        log.info("codecFactory.getCodec({})={}", path, compressionCodec);
        if (compressionCodec == null) {
            log.error("no codec found for uri {}", uri);
            System.exit(1);
        }

        String outputUri = CompressionCodecFactory.removeSuffix(uri, compressionCodec.getDefaultExtension());
        InputStream in = null;
        OutputStream out = null;

        try {
            in = compressionCodec.createInputStream(fs.open(path));
            out = fs.create(new Path(outputUri));
            IOUtils.copyBytes(in, out, conf);
        } finally {
            IOUtils.closeStream(in);
            IOUtils.closeStream(out);
        }
    }
}
