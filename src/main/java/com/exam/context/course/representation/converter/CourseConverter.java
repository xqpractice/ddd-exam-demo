package com.exam.context.course.representation.converter;

import com.exam.context.course.domain.model.Course;
import com.exam.context.course.domain.model.CourseId;
import com.exam.context.course.representation.response.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
@SuppressWarnings("squid:S1214")
public interface CourseConverter {
    CourseConverter CONVERTER = Mappers.getMapper(CourseConverter.class);

    List<CourseResponse> toResponse(List<Course> courses);

    CourseResponse toResponse(Course course);

    default String toId(CourseId courseId) {
        return courseId.getId();
    }
}
