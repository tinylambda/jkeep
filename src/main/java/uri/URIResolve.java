package uri;

import java.net.URI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class URIResolve {
    public static void main(String[] args) {
        URI uri = URI.create("/tmp");
        String filename = uri.resolve("a.txt").toString();
        log.info("{}", filename);

        uri = URI.create("/tmp/");
        filename = uri.resolve("a.txt").toString();
        log.info("{}", filename);
    }
}
