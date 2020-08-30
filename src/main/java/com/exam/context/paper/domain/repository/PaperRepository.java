package com.exam.context.paper.domain.repository;

import com.exam.context.paper.domain.model.paper.Paper;
import com.exam.context.paper.domain.model.paper.PaperId;

import java.util.List;
import java.util.Optional;

public interface PaperRepository {
    Optional<Paper> find(PaperId paperId);

    void save(Paper paper);

    List<Paper> getAll();
}
