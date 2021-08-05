package string;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringBuilderVsBuffer {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(80);

    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, 1000).forEach(i -> EXECUTOR_SERVICE.submit(() -> {
            stringBuilder.append("i");
        }));

        StringBuffer stringBuffer = new StringBuffer();
        IntStream.range(0, 1000).forEach(i -> EXECUTOR_SERVICE.submit(() -> {
            stringBuffer.append("j");
        }));

        EXECUTOR_SERVICE.shutdown();
        EXECUTOR_SERVICE.awaitTermination(1, TimeUnit.DAYS);
        log.info("Builder<not thread safe>: {}", stringBuilder.toString().length());
        log.info("Buffer<thread safe>: {}", stringBuffer.toString().length());
    }
}
