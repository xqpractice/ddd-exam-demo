package com.exam.context.course.representation.controller;

import com.exam.context.course.application.command.PublishCourseCommand;
import com.exam.context.course.application.service.CourseApplicationService;
import com.exam.context.course.domain.model.CourseId;
import com.exam.context.course.query.CourseQueryService;
import com.exam.context.course.representation.request.CourseCreateRequest;
import com.exam.context.course.representation.response.CourseIdResponse;
import com.exam.context.course.representation.response.CourseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.exam.context.course.representation.converter.CourseConverter.CONVERTER;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseApplicationService applicationService;
    private final CourseQueryService queryService;

    public CourseController(CourseApplicationService applicationService, CourseQueryService queryService) {
        this.applicationService = applicationService;
        this.queryService = queryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseIdResponse create(@RequestBody CourseCreateRequest request) {
        return CourseIdResponse.of(applicationService.create(request.toCommand()));
    }

    @PutMapping("/{courseId}/publish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void publish(@PathVariable String courseId) {
        applicationService.publish(PublishCourseCommand.builder().courseId(new CourseId(courseId)).build());
    }

    @GetMapping
    public List<CourseResponse> getAll() {
        return CONVERTER.toResponse(queryService.getAll());
    }

    @GetMapping("/{courseId}")
    public CourseResponse getOne(@PathVariable String courseId) {
        return CONVERTER.toResponse(queryService.getOne(new CourseId(courseId)));
    }
}
