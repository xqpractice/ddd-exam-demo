package com.exam.context.course.representation.response;

import com.exam.context.course.domain.model.CourseId;
import com.exam.context.course.domain.model.CourseStatus;
import com.exam.context.examination.domain.model.ExaminationId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String id;
    private String name;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<File> materials;
    private String examinationId;
}
