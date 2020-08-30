package com.exam.context.common;

public interface Entity<T> {
    boolean sameIdentityAs(T other);
}
