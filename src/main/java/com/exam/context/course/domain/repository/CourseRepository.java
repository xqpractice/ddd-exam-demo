package com.exam.context.course.domain.repository;

import com.exam.context.course.domain.model.Course;
import com.exam.context.course.domain.model.CourseId;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    Optional<Course> find(CourseId courseId);

    void save(Course blankQuiz);

    List<Course> getAll();
}
