package com.languajesignalgroup.lsm_web.services.impl;

import com.languajesignalgroup.lsm_web.dto.LessonDto;
import com.languajesignalgroup.lsm_web.models.Course;
import com.languajesignalgroup.lsm_web.models.Lesson;
import com.languajesignalgroup.lsm_web.repository.CourseRepository;
import com.languajesignalgroup.lsm_web.repository.LessonRepository;
import com.languajesignalgroup.lsm_web.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import  static com.languajesignalgroup.lsm_web.mapper.CourseMapper.mapToCourse;
import static com.languajesignalgroup.lsm_web.mapper.LessonMapper.mapToLesson;
import static com.languajesignalgroup.lsm_web.mapper.LessonMapper.mapToLessonDto;

@Service
public class LessonServiceImpl implements LessonService {
    private LessonRepository lessonRepository;
    private CourseRepository courseRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void createLesson(Long courseId, LessonDto lessonDto) {
        Course course = courseRepository.findById(courseId).get();
        Lesson lesson = mapToLesson(lessonDto);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
    }

    @Override
    public List<LessonDto> findAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        return lessons.stream().map(lesson -> mapToLessonDto(lesson)).collect(Collectors.toList());
    }

    @Override
    public LessonDto findByLessonId(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        return mapToLessonDto(lesson);
    }

    @Override
    public void updateLesson(LessonDto lessonDto) {
        Lesson lesson = mapToLesson(lessonDto);
        lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(long lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
