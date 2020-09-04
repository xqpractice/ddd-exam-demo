package com.exam.context.course.representation.request;

import com.exam.context.course.application.command.CreateCourseCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateRequest {
    private String name;
    private int dueDays;
    private LocalDate startDate;

    public CreateCourseCommand toCommand() {
        return CreateCourseCommand.builder()
            .name(name)
            .dueDays(dueDays)
            .startDate(startDate)
            .build();
    }
}
