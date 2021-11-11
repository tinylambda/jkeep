package functional;

import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-11
 */
@Slf4j
@Data
public class FunctionalBiConsumer {
    private static final Random RANDOM = new Random();
    private Integer num;

    public void useBiConsumer(String name, BiConsumer<String, FunctionalBiConsumer> biConsumer) {
        this.num = RANDOM.nextInt(100);
        biConsumer.accept(name, this);
    }

    public static void main(String[] args) {
        FunctionalBiConsumer functionalBiConsumer = new FunctionalBiConsumer();
        functionalBiConsumer.useBiConsumer("Hello", (s, functionalBiConsumer1) -> {
            for (int i=0; i < functionalBiConsumer1.getNum(); i++) {
                log.info("output {}", i);
            }
        });
    }
}
