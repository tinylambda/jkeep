package statictest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticInheritanceTest extends StaticInheritance {
    public static void main(String[] args) {
        log.info("{}", EXCLUDE);
        log.info("{}", EXCLUDE_PUBLIC);
        // cannot access EXCLUDE_PRIVATE
    }
}
