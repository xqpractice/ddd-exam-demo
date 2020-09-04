package com.exam.context.course.representation.response;

import com.exam.context.course.domain.model.CourseId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseIdResponse {
    private String uri;

    public static CourseIdResponse of(CourseId courseId) {
        return new CourseIdResponse("courses/" + courseId);
    }
}
