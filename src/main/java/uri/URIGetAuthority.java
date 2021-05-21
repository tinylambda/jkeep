package uri;


import java.net.URI;
import java.net.URISyntaxException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class URIGetAuthority {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("http://user:pass@baidu.com:8080/a/b/c?arg=value");
        log.info(uri.toString());
        log.info(uri.getAuthority());
        log.info(uri.getScheme());
    }
}
