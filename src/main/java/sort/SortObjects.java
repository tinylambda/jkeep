package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortObjects {
    private static final Random random = new Random();
    @Data
    static class SimpleObject {
        long questionId;
        long timestamp;
    }

    public static void main(String[] args) {
        List<SimpleObject> simpleObjects = new ArrayList<>();
        for (int i=0; i<100; i++) {
            SimpleObject simpleObject = new SimpleObject();
            long questionId = random.nextInt(10);
            simpleObject.setQuestionId(questionId);
            simpleObject.setTimestamp(random.nextInt(100));
            simpleObjects.add(simpleObject);
        }

        // 根据时间戳来排序
        simpleObjects.sort((simpleObjectOne, simpleObjectTwo) -> {
            long t1 = simpleObjectOne.getTimestamp();
            long t2 = simpleObjectTwo.getTimestamp();
            long q1 = simpleObjectOne.getQuestionId();
            long q2 = simpleObjectOne.getQuestionId();
            int compareResult = Long.compare(t1, t2);
            return compareResult == 0 ? Long.compare(q1, q2) : compareResult;
        });

        for (SimpleObject simpleObject : simpleObjects) {
            log.info("{}", simpleObject);
        }

    }
}
