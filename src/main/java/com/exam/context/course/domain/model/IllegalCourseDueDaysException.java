package com.exam.context.course.domain.model;

class IllegalCourseDueDaysException extends IllegalArgumentException {

    public IllegalCourseDueDaysException(int actual) {
        super("TooLittleDueDaysException: exception:3~90, actual:" + actual);
    }
}
