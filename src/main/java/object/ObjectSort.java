package object;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectSort {
    @Data
    @AllArgsConstructor
    static class Question {
        private boolean answered;
        private long seq;
    }

    public static void main(String[] args) {
        List<Question> questions = Lists.newArrayList(
                new Question(true, 1),
                new Question(true, 2),
                new Question(false, 3),
                new Question(true, 4),
                new Question(true, 5),
                new Question(false, 6),
                new Question(false, 7),
                new Question(false, 8),
                new Question(false, 9),
                new Question(false, 10)
        );

        Comparator<Question> comparator = Comparator.comparingLong(Question::getSeq);
        Stream<Question> answeredQuestions = questions.stream().filter(Question::isAnswered);
        Stream<Question> notAnsweredQuestions = questions.stream().filter(question -> !question.isAnswered());

        List<Question> sortedQuestions = Streams.concat(
                notAnsweredQuestions.sorted(comparator),
                answeredQuestions.sorted(comparator)
        ).collect(Collectors.toList());

        sortedQuestions.forEach(item -> {
            log.info("\t{}", item);
        });
    }

}
