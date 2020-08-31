package com.exam.context.course.application.command;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CreateCourseCommand {
    private String name;
    private int dueDays;
    private LocalDate startDate;
}
