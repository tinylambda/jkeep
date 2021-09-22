package guava;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuavaCheckArgument {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int next = RANDOM.nextInt(10);
        // message can use template syntax
        checkArgument(next % 2 == 0, "value %s is not even %s", next, next);
    }
}
