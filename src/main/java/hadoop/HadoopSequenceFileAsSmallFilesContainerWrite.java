package hadoop;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.compress.DefaultCodec;
import org.apache.hadoop.shaded.org.apache.commons.io.FileUtils;
import org.apache.hadoop.util.ReflectionUtils;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HadoopSequenceFileAsSmallFilesContainerWrite {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.file.impl", "org.apache.hadoop.fs.RawLocalFileSystem");
        File inFileOne = new File("/tmp/test.txt");
        File inFileTwo = new File("/tmp/test2.txt");
        Text key = new Text();  // filename
        Text value = new Text();  // file content

        SequenceFile.Writer writer = null;
        SequenceFile.Reader reader = null;
        SequenceFile.Metadata metadata = new SequenceFile.Metadata();
        log.info("write the first file");
        try {
            writer = SequenceFile.createWriter(
                    configuration,
                    SequenceFile.Writer.file(new Path("/tmp/test")),
                    SequenceFile.Writer.keyClass(key.getClass()),
                    SequenceFile.Writer.valueClass(value.getClass()),
                    SequenceFile.Writer.bufferSize(8192),
                    SequenceFile.Writer.compression(SequenceFile.CompressionType.BLOCK, new DefaultCodec()),
                    SequenceFile.Writer.progressable(null),
                    SequenceFile.Writer.appendIfExists(true),
                    SequenceFile.Writer.metadata(metadata)

            );

            key.set("file1");
            String content = FileUtils.readFileToString(inFileOne);
            value.set(content);
            writer.append(key, value);
        } finally {
            IOUtils.closeStream(writer);
        }

        log.info("write the second file");

        try {
            writer = SequenceFile.createWriter(
                    configuration,
                    SequenceFile.Writer.file(new Path("/tmp/test")),
                    SequenceFile.Writer.keyClass(key.getClass()),
                    SequenceFile.Writer.valueClass(value.getClass()),
                    SequenceFile.Writer.bufferSize(8192),
                    SequenceFile.Writer.compression(SequenceFile.CompressionType.BLOCK, new DefaultCodec()),
                    SequenceFile.Writer.progressable(null),
                    SequenceFile.Writer.appendIfExists(true),
                    SequenceFile.Writer.metadata(metadata)
            );

            key.set("file2");
            String content = FileUtils.readFileToString(inFileTwo);
            value.set(content);
            writer.append(key, value);
        } finally {
            IOUtils.closeStream(writer);
        }

        log.info("now try to read file");

        try {
            reader = new SequenceFile.Reader(
                    configuration,
                    SequenceFile.Reader.file(new Path("/tmp/test")),
                    SequenceFile.Reader.bufferSize(8192),
                    SequenceFile.Reader.start(0)
            );
            Writable readKey = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(), configuration);
            Text readValue = (Text) ReflectionUtils.newInstance(reader.getValueClass(), configuration);
            while (reader.next(readKey, readValue)) {
                String syncSeen = reader.syncSeen() ? "*" : "";
                log.info("[{}]\t{}\t{}\n", syncSeen, readKey, readValue.getLength());
            }


        } finally {
            IOUtils.closeStream(reader);
        }
    }
}
