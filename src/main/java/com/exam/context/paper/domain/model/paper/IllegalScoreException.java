package com.exam.context.paper.domain.model.paper;

public class IllegalScoreException extends IllegalArgumentException {
    public IllegalScoreException(int score) {
        super("IllegalScoreException: exception score is not 100, actual:" + score);
    }
}
