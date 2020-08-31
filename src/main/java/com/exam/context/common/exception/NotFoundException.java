package com.exam.context.common.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Class<?> entityClass) {
        super("Got nothing of" + entityClass.getName() + "from db");
    }
}
