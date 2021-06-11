package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortTwoPhases {
    private static final Random random = new Random();

    @Data
    static class SimpleObject {
        long questionType;
        long answerTime;
        long createTime;
        long questionId;
        long timestamp;
    }

    public static void main(String[] args) {
        List<SimpleObject> simpleObjects = new ArrayList<>();
        for (int i=0; i<100; i++) {
            long questionType = random.nextInt(2);
            long answerTime = random.nextLong();
            long createTime = random.nextLong();
            long timestamp = random.nextLong();

            SimpleObject simpleObject = new SimpleObject();
            simpleObject.setQuestionType(questionType);
            simpleObject.setAnswerTime(answerTime);
            simpleObject.setCreateTime(createTime);
            simpleObject.setQuestionId(i);
            simpleObject.setTimestamp(timestamp);

            simpleObjects.add(simpleObject);
        }

        List<SimpleObject> simpleObjectsPartOne = simpleObjects.stream()
                .filter(simpleObject -> simpleObject.getQuestionType() == 0)
                .sorted(Comparator.comparingLong(SimpleObject::getAnswerTime)).collect(Collectors.toList());
        List<SimpleObject> simpleObjectsPartTwo = simpleObjects.stream()
                .filter(simpleObject -> simpleObject.getQuestionType() == 1)
                .sorted(Comparator.comparingLong(SimpleObject::getCreateTime)).collect(Collectors.toList());
        simpleObjectsPartOne.addAll(simpleObjectsPartTwo);
        for (SimpleObject simpleObject : simpleObjectsPartOne) {
            log.info("{}", simpleObject);
        }
    }
}
