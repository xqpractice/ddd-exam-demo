package com.exam.context.paper.infrastructure.repository;

import com.exam.context.paper.domain.model.blankquiz.BlankQuiz;
import com.exam.context.paper.domain.model.blankquiz.BlankQuizId;
import com.exam.context.paper.domain.repository.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizzes = new HashSet<>();

    @Override
    public Optional<BlankQuiz> find(BlankQuizId blankQuizId) {
        return blankQuizzes.stream().filter(p -> blankQuizId.equals(p.getBlankQuizId())).findFirst();
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizzes.add(blankQuiz);
    }

    @Override
    public List<BlankQuiz> getAll() {
        return new ArrayList<>(blankQuizzes);
    }
}
