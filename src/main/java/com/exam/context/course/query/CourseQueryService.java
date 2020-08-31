package com.exam.context.course.query;

import com.exam.context.common.exception.NotFoundException;
import com.exam.context.course.domain.model.Course;
import com.exam.context.course.domain.model.CourseId;
import com.exam.context.course.domain.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseQueryService {
    private final CourseRepository repository;

    public CourseQueryService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAll() {
        return repository.getAll();
    }

    public Course getOne(CourseId courseId) {
        return repository.find(courseId).orElseThrow(() -> new NotFoundException(Course.class));
    }
}
