package com.exam.context.course.domain.model;

import com.exam.context.common.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@AllArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class CourseId implements ValueObject<CourseId> {
    private String id;

    public static CourseId nextId() {
        return new CourseId(UUID.randomUUID().toString());
    }

    @Override
    public boolean sameValueAs(CourseId other) {
        return equals(other);
    }
}
