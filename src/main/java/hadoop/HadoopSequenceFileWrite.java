package hadoop;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.DefaultCodec;
import org.apache.hadoop.shaded.org.apache.commons.io.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HadoopSequenceFileWrite {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(configuration);
        File inFile = new File("/tmp/test.txt");
        Text key = new Text();
        LongWritable value = new LongWritable();

        SequenceFile.Writer writer = null;
        SequenceFile.Metadata metadata = new SequenceFile.Metadata();
        try {
            writer = SequenceFile.createWriter(
                    configuration,
                    SequenceFile.Writer.file(new Path("/tmp/test")),
                    SequenceFile.Writer.keyClass(key.getClass()),
                    SequenceFile.Writer.valueClass(value.getClass()),
                    SequenceFile.Writer.bufferSize(8192),
                    SequenceFile.Writer.compression(SequenceFile.CompressionType.BLOCK, new DefaultCodec()),
                    SequenceFile.Writer.progressable(null),
                    SequenceFile.Writer.metadata(metadata)

            );
            int ctr = 100;
            for (String line : FileUtils.readLines(inFile)) {
                key.set(String.valueOf(ctr++));
                value.set(Long.valueOf(line));
                if (ctr < 150) {
                    log.info("[{}]\t{}\t{}\n", writer.getLength(), key, value);
                }
                writer.append(key, value);
            }

        } finally {
            IOUtils.closeStream(writer);
        }
    }
}
