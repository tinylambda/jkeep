package benchmark;


import static java.util.stream.Collectors.toList;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import io.vavr.collection.Stream;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class BenchMarkObjectCreation {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        int n = 1000000;

        long start = System.currentTimeMillis();
        Stream.range(0, n+1).map(index -> new BenchMarkObjectCreation("felix", 20)).collect(toList());
        long end = System.currentTimeMillis();

        long costMillis = end - start;
        long costSeconds = TimeUnit.SECONDS.convert(costMillis, TimeUnit.MILLISECONDS);
        log.info("cost {} seconds ({} millis)", costSeconds, costMillis);
    }
}
