package com.languajesignalgroup.lsm_web.services;

import com.languajesignalgroup.lsm_web.dto.LessonDto;

import  java.util.List;

public interface LessonService {
    void createLesson(Long lessonId, LessonDto lessonDto);

    List<LessonDto> findAllLessons();

    LessonDto findByLessonId(Long LessonId);

    void updateLesson(LessonDto lessonDto);

    void deleteLesson(long lessonId);
}
