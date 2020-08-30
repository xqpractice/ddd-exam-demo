package com.exam.context.course.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCourseCommand {
    private String name;
}
