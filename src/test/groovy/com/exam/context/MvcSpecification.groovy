package com.exam.context

import com.exam.context.course.domain.repository.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
class MvcSpecification extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    CourseRepository courseRepository
}
