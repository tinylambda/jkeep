package path;

import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PathJoin {
    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        log.info("{}", currentPath);

        Path filePath = Paths.get(currentPath.toString(), "data", "hello.txt");
        log.info("{}", filePath);
    }
}
