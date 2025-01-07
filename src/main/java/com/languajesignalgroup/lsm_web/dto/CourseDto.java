package com.languajesignalgroup.lsm_web.dto;

import com.languajesignalgroup.lsm_web.models.Category;
import com.languajesignalgroup.lsm_web.models.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CourseDto {
    private Long courseId; // Course Id

    private String courseName; // Course Name

    private String courseCover; // Course Cover Picture

    private String courseDescription; //Course Description

    private Long userId;

    private Long categoryId;

    private LocalDateTime creationDate;

    private LocalDateTime updatedOn;

    private List<Long> lessons;

    private List<Long> enrollments;
}
