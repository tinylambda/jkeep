package hadoop;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HadoopSequenceFileRead {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        SequenceFile.Reader reader = null;

        try {
            reader = new SequenceFile.Reader(
                    configuration,
                    SequenceFile.Reader.file(new Path("/tmp/test")),
                    SequenceFile.Reader.bufferSize(8192),
                    SequenceFile.Reader.start(0)
            );
            Writable key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(), configuration);
            Writable value = (Writable) ReflectionUtils.newInstance(reader.getValueClass(), configuration);
            while (reader.next(key, value)) {
                String syncSeen = reader.syncSeen() ? "*" : "";
                log.info("[{}]\t{}\t{}\n", syncSeen, key, value);
            }
        } finally {
            IOUtils.closeStream(reader);
        }
    }
}
