package com.exam.context.paper.domain.model.paper;

import com.exam.context.common.Entity;
import com.exam.context.common.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(of = {"paperId"})
public class Paper implements Entity<Paper> {
    private static final int MAX_QUIZ_SIZE = 20;
    private static final int MIN_QUIZ_SIZE = 5;
    public static final int TOTAL_SCORE = 100;

    @Getter
    private PaperId paperId;
    @Getter
    private String teacherId;
    @Getter
    private LocalDateTime createTime;
    private List<BlankQuiz> blankQuizzes;

    private Paper(PaperId paperId, String teacherId, List<BlankQuiz> blankQuizzes) {
        this.paperId = paperId;
        this.blankQuizzes = blankQuizzes;
        this.teacherId = teacherId;
        createTime = LocalDateTime.now();
    }

    public static Paper assemble(String teacherId, List<BlankQuiz> blankQuizzes) {
        validateQuizzes(blankQuizzes);
        return new Paper(PaperId.nextId(), teacherId, blankQuizzes);
    }

    private static void validateQuizzes(List<BlankQuiz> blankQuizzes) {
        if (blankQuizzes.size() > MAX_QUIZ_SIZE || blankQuizzes.size() < MIN_QUIZ_SIZE) {
            throw new IllegalQuizzesCountException(blankQuizzes.size());
        }

        int totalScore = blankQuizzes.stream().mapToInt(BlankQuiz::getScore).sum();
        if (totalScore != TOTAL_SCORE) {
            throw new IllegalScoreException(totalScore);
        }
    }

    public Collection<Object> getQuizzes() {
        return Collections.unmodifiableList(blankQuizzes);
    }

    public void reassemble(String teacherId, List<BlankQuiz> blankQuizzes) {
        validateQuizzes(blankQuizzes);
        this.teacherId = teacherId;
        this.blankQuizzes = blankQuizzes;
    }

    @Override
    public boolean sameIdentityAs(Paper other) {
        return paperId.sameValueAs(other.paperId);
    }

    @Getter
    @AllArgsConstructor
    public static class BlankQuiz implements ValueObject<BlankQuiz> {
        private String quizId;
        private int score;

        @Override
        public boolean sameValueAs(BlankQuiz other) {
            return false;
        }
    }
}
