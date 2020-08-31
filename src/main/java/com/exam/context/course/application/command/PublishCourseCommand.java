package com.exam.context.course.application.command;

import com.exam.context.course.domain.model.CourseId;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PublishCourseCommand {
    private CourseId courseId;
}
