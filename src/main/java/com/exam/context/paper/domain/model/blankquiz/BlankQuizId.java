package com.exam.context.paper.domain.model.blankquiz;

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
public class BlankQuizId implements ValueObject<BlankQuizId> {
    private String id;

    public static BlankQuizId nextId() {
        return new BlankQuizId(UUID.randomUUID().toString());
    }

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return equals(other);
    }
}
