package com.exam.context.course.application.service;

import com.exam.context.common.exception.NotFoundException;
import com.exam.context.course.application.command.CreateCourseCommand;
import com.exam.context.course.application.command.PublishCourseCommand;
import com.exam.context.course.domain.model.Course;
import com.exam.context.course.domain.model.CourseId;
import com.exam.context.course.domain.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseApplicationService {
    private final CourseRepository repository;

    public CourseApplicationService(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseId create(CreateCourseCommand command) {
        Course course = Course.create(command.getName(), command.getStartDate(), command.getDueDays());
        repository.save(course);
        return course.getCourseId();
    }

    public void publish(PublishCourseCommand command) {
        Course course = repository.find(command.getCourseId())
            .orElseThrow(() -> new NotFoundException(Course.class));
        course.publish();
        repository.save(course);
    }
}
