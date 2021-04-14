package uuid;


import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UUIDGenerate {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        log.info("" + uuid.variant());
        log.info("" + uuid.version()); // v4
        String uuidAsString = uuid.toString();
        log.info(uuidAsString);
    }
}
