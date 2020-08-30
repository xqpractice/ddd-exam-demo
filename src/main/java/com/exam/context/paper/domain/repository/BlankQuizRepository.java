package com.exam.context.paper.domain.repository;

import com.exam.context.paper.domain.model.blankquiz.BlankQuiz;
import com.exam.context.paper.domain.model.blankquiz.BlankQuizId;

import java.util.List;
import java.util.Optional;

public interface BlankQuizRepository {
    Optional<BlankQuiz> find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

    List<BlankQuiz> getAll();
}
