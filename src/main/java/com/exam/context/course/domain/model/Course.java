package com.exam.context.course.domain.model;

import com.exam.context.common.Entity;
import com.exam.context.examination.domain.model.ExaminationId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Getter
@EqualsAndHashCode(of = {"courseId"})
public class Course implements Entity<Course> {
    private static final int MAX_DUE_DAYS = 90;
    private static final int MIN_DUE_DAYS = 3;

    private CourseId courseId;
    private String name;
    private CourseStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<File> materials;
    private ExaminationId examinationId;

    private Course(CourseId courseId, String name, LocalDate startDate, LocalDate endDate) {
        this.courseId = courseId;
        this.name = name;
        this.status = CourseStatus.INIT;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Course create(String name, LocalDate startDate, int dueDays) {
        validateDueDays(dueDays);
        return new Course(CourseId.nextId(), name, startDate, startDate.plusDays(dueDays));
    }

    private static void validateDueDays(int dueDays) {
        if (dueDays > MAX_DUE_DAYS || dueDays < MIN_DUE_DAYS) {
            throw new IllegalCourseDueDaysException(dueDays);
        }
    }

    public void assignExam(ExaminationId examinationId) {
        this.examinationId = examinationId;
    }

    public void attachMaterials(List<File> materials) {
        this.materials = materials;
    }

    public void publish() {
        this.status = CourseStatus.PUBLISHED;
    }

    @Override
    public boolean sameIdentityAs(Course other) {
        return courseId.sameValueAs(other.courseId);
    }
}
