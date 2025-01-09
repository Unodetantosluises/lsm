package com.languajesignalgroup.lsm_web.dto;

import com.languajesignalgroup.lsm_web.models.Course;
import com.languajesignalgroup.lsm_web.models.LessonType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LessonDto {
    private Long lessonId;

    private String title;

    private String instructions;

    private LessonType type;

    private String content;

    private String media;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;

    private Course course;
}