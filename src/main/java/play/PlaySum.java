package play;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlaySum {
    private int sum(int n) {
        int s = n;
        while (n > 0) {
            n -= 1;
            s += n;
        }
        return s;
    }

    public static void main(String[] args) {
        PlaySum playSum = new PlaySum();
        log.info("{}", playSum.sum(1));
        log.info("{}", playSum.sum(2));
        log.info("{}", playSum.sum(3));
        log.info("{}", playSum.sum(Integer.MAX_VALUE)); // wrong
    }
}
