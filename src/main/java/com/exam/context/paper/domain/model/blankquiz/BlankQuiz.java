package com.exam.context.paper.domain.model.blankquiz;

import com.exam.context.common.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;
    private String teacherId;
    private String description;
    private String referenceAnswer;
    private LocalDateTime createTime;

    private BlankQuiz(BlankQuizId blankQuizId, String teacherId, String description, String referenceAnswer) {
        this.blankQuizId = blankQuizId;
        this.teacherId = teacherId;
        this.description = description;
        this.referenceAnswer = referenceAnswer;
        createTime = LocalDateTime.now();
    }

    public static BlankQuiz create(String teacherId, String description, String referenceAnswer) {
        return new BlankQuiz(BlankQuizId.nextId(), teacherId, description, referenceAnswer);
    }

    public void updateDescription(String description, String referenceAnswer) {
        this.description = description;
        this.referenceAnswer = referenceAnswer;
    }

    public void updateReferenceAnswer(String referenceAnswer) {
        this.referenceAnswer = referenceAnswer;
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.blankQuizId);
    }
}
