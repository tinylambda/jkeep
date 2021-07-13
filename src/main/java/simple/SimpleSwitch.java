package simple;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleSwitch {

    private void testSwitch(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                log.info("{} -> 1,2,3", i);
                break;
            case 4:
            case 5:
                log.info("{} -> 4,5", i);
                break;
            default:
                log.info("{} -> others", i);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        SimpleSwitch simpleSwitch = new SimpleSwitch();

        for (int i = 0; i < 100; i++) {
            int seq = random.nextInt(10);
            simpleSwitch.testSwitch(seq);
        }
    }
}
