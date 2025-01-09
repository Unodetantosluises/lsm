package com.languajesignalgroup.lsm_web.services;

import com.languajesignalgroup.lsm_web.dto.CourseDto;
import com.languajesignalgroup.lsm_web.models.Course;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAllCourses();

    Course saveCourse(CourseDto courseDto);

    CourseDto findCourseById(Long courseId);

    void delete(long courseId);

    List<CourseDto> searchCourses(String query);
}
