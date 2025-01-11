package com.languajesignalgroup.lsm_web.dto;

import com.languajesignalgroup.lsm_web.models.Category;
import com.languajesignalgroup.lsm_web.models.Users;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CourseDto {
    private Long courseId; // Course Id

    @NotEmpty(message = "Course name should not be empty")
    private String courseName; // Course Name

    @NotEmpty(message = "Course cover should not be empty")
    private String courseCover; // Course Cover Picture

    @NotEmpty(message = "Course description should not be empty")
    private String courseDescription; //Course Description

    private Long userId; // User Id

    private Long categoryId; // Category Id

    private LocalDateTime creationDate; // Creation date of the Course

    private LocalDateTime updatedOn; // Update date of the Course

    private List<LessonDto> lesson; // Lessons of the  Course

    private List<Long> enrollments; // List of Enrolled user in the Course
}
