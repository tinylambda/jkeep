package path;

import java.net.URI;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PathGetPath {
    public static void main(String[] args) {
        String dataDir = "/home/ad/dw/ks_ad_dev.db/orientation_operations_new";
        Long taskId = 1000200L;
        String subDir = String.format("operation_id=%s", taskId);
        URI fullPathUri = Paths.get(dataDir, subDir).toUri();
        log.info("{}", fullPathUri.getPath());
    }
}
