package hadoop;

import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HadoopListSupportedCodecs {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        List<Class<? extends CompressionCodec>> codecClasses = CompressionCodecFactory.getCodecClasses(conf);
        for (Class<? extends CompressionCodec> clazz : codecClasses) {
            String codecName = clazz.getSimpleName();
            String ext = clazz.newInstance().getDefaultExtension();
            log.info("{}({}) -> {}", codecName, clazz.getCanonicalName(), ext);
        }
    }
}
