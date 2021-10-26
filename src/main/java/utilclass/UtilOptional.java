package utilclass;


import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilOptional {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Optional<String> emptyString = Optional.empty();
        log.info("{}", emptyString);
        log.info("{}", emptyString.isPresent());
        log.info("{}", emptyString.orElse("abc"));
        emptyString.ifPresent(log::info);

        emptyString = Optional.of("def");
        emptyString.ifPresent(log::info);

        emptyString = Optional.ofNullable("xyz");
        emptyString.ifPresent(log::info);

        log.info("{}", emptyString);

        emptyString = Optional.ofNullable("mmmm");
        emptyString.map(s -> {
            log.info("go {}", s);
            return "go up";
        }).ifPresent(log::info);

//        emptyString = Optional.of(null);  // NPE

        byte[] bytes = null;
        if (RANDOM.nextInt(10) % 2 == 0) {
            bytes = "good".getBytes(StandardCharsets.UTF_8);
        }
        int length = Optional.ofNullable(bytes).orElse("".getBytes(StandardCharsets.UTF_8)).length;
        log.info("{}", length);

        String info = null;
        if (RANDOM.nextInt(10) % 2 == 0) {
            info = "good";
        }

        log.info("{}", Optional.ofNullable(info).map(Object::toString).orElse("default string"));
    }
}
