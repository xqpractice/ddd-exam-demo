package com.exam.context.common;

public interface ValueObject<T> {
    boolean sameValueAs(T other);
}
