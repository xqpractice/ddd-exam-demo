package com.exam.context.examination.domain.model;

import com.exam.context.common.ValueObject;
import com.exam.context.course.domain.model.CourseId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class ExaminationId implements ValueObject<ExaminationId> {
    private String id;

    public static ExaminationId nextId() {
        return new ExaminationId(UUID.randomUUID().toString());
    }

    @Override
    public boolean sameValueAs(ExaminationId other) {
        return equals(other);
    }
}
