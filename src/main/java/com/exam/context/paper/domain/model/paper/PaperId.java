package com.exam.context.paper.domain.model.paper;

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
public class PaperId implements ValueObject<PaperId> {
    private String id;

    public static PaperId nextId() {
        return new PaperId(UUID.randomUUID().toString());
    }

    @Override
    public boolean sameValueAs(PaperId other) {
        return equals(other);
    }
}
