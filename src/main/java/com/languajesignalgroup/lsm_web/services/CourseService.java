package com.languajesignalgroup.lsm_web.services;

import com.languajesignalgroup.lsm_web.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAllCourses();
}
