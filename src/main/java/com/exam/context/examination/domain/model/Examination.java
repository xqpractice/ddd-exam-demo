package com.exam.context.examination.domain.model;

import com.exam.context.common.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"examinationId"})
public class Examination implements Entity<Examination> {
    private ExaminationId examinationId;

    @Override
    public boolean sameIdentityAs(Examination other) {
        return examinationId.sameValueAs(other.examinationId);
    }
}
