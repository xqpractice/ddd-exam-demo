package com.exam.context.course.representation.controller

import com.exam.context.MvcSpecification
import com.exam.context.course.domain.model.Course
import com.exam.context.course.domain.repository.CourseRepository
import com.exam.context.course.representation.request.CourseCreateRequest
import com.exam.context.course.representation.response.CourseIdResponse
import com.exam.context.course.representation.response.CourseResponse
import org.springframework.http.HttpStatus

import java.time.LocalDate

class CourseControllerSpec extends MvcSpecification {

    def 'should create course request success'() {
        given:
            def request = new CourseCreateRequest(name: 'Learning Spock', dueDays: 10, startDate: LocalDate.now().plusDays(10))

        when:
            def result = restTemplate.postForEntity('/api/courses', request, CourseIdResponse.class)

        then:
            result.statusCode == HttpStatus.CREATED
            result.body.uri.length() > 0
    }

    def 'should fetch one course success'() {
        given:
            def course = Course.create('Learning SPock', LocalDate.now(), 10)
            courseRepository.save(course)

        when:
            def result = restTemplate.getForEntity("/api/courses/${course.courseId.id}", CourseResponse.class)

        then:
            result.statusCode == HttpStatus.OK
            result.body.id == course.courseId.id
    }
}
