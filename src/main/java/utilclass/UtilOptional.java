package utilclass;


import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilOptional {
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
    }
}
