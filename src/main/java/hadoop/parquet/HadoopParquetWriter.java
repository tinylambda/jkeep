package hadoop.parquet;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.column.ParquetProperties;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.example.GroupWriteSupport;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;

public class HadoopParquetWriter {
    public static void main(String[] args) throws Exception {
        int m0 = 128;
        int m1 = 1024;
        Configuration configuration = new Configuration();
        MessageType messageType = MessageTypeParser.parseMessageType("message test_schema {optional int64 uid;}");
        Path path = new Path("/tmp/data/testdata");
        GroupWriteSupport.setSchema(messageType, configuration);
        ParquetWriter parquetWriter = new ParquetWriter(path, new GroupWriteSupport(), CompressionCodecName.GZIP, m0 * m1 * m1, m1, m1 * m1, true, false, ParquetProperties.WriterVersion.PARQUET_1_0, configuration);

        SimpleGroupFactory simpleGroupFactory = new SimpleGroupFactory(messageType);

        long[] uids = {1000l, 2000l, 3000l, 4000l, 5000l};
        for(long uid : uids) {
            Group group = simpleGroupFactory.newGroup();
            group.append("uid", uid);
            parquetWriter.write(group);
        }
        parquetWriter.close();
    }
}
