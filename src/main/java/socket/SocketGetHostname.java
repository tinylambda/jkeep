package socket;


import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketGetHostname {
    public static void main(String[] args) throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        log.info(hostname);
    }
}
