package com.exam.context.course.infrastructure.repository;

import com.exam.context.course.domain.model.Course;
import com.exam.context.course.domain.model.CourseId;
import com.exam.context.course.domain.repository.CourseRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class MemoryCourseRepository implements CourseRepository {
    private Set<Course> courses = new HashSet<>();

    @Override
    public Optional<Course> find(CourseId courseId) {
        return courses.stream().filter(p -> courseId.equals(p.getCourseId())).findFirst();
    }

    @Override
    public void save(Course paper) {
        courses.add(paper);
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<>(courses);
    }
}
