package com.languajesignalgroup.lsm_web.mapper;

import com.languajesignalgroup.lsm_web.dto.LessonDto;
import com.languajesignalgroup.lsm_web.models.Lesson;

public class LessonMapper {
    public static Lesson mapToLesson(LessonDto lessonDto) {
        return Lesson.builder()
                .lessonId(lessonDto.getLessonId())
                .title(lessonDto.getTitle())
                .instructions(lessonDto.getInstructions())
                .type(lessonDto.getType())
                .content(lessonDto.getContent())
                .media(lessonDto.getMedia())
                .creationDate(lessonDto.getCreationDate())
                .updateDate(lessonDto.getUpdateDate())
                .course(lessonDto.getCourse())
                .build();
    }

    public static LessonDto mapToLessonDto(Lesson lesson) {
        return LessonDto.builder()
                .lessonId(lesson.getLessonId())
                .title(lesson.getTitle())
                .instructions(lesson.getInstructions())
                .type(lesson.getType())
                .content(lesson.getContent())
                .media(lesson.getMedia())
                .creationDate(lesson.getCreationDate())
                .updateDate(lesson.getUpdateDate())
                .course(lesson.getCourse())
                .build();
    }
}
