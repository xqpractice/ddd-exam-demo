package com.exam.context.paper.domain.model.paper;

class IllegalQuizzesCountException extends IllegalArgumentException {

    public IllegalQuizzesCountException(int actual) {
        super("TooManyQuizzesException: exception:5~20, actual:" + actual);
    }
}
