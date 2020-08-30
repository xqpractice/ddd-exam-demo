package com.exam.context.paper.infrastructure.repository;

import com.exam.context.paper.domain.model.paper.Paper;
import com.exam.context.paper.domain.model.paper.PaperId;
import com.exam.context.paper.domain.repository.PaperRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class MemoryPaperRepository implements PaperRepository {
    private Set<Paper> papers = new HashSet<>();

    @Override
    public Optional<Paper> find(PaperId paperId) {
        return papers.stream().filter(p -> paperId.equals(p.getPaperId())).findFirst();
    }

    @Override
    public void save(Paper paper) {
        papers.add(paper);
    }

    @Override
    public List<Paper> getAll() {
        return new ArrayList<>(papers);
    }
}
