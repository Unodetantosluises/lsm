package com.languajesignalgroup.lsm_web.services.impl;

import com.languajesignalgroup.lsm_web.dto.CourseDto;
import com.languajesignalgroup.lsm_web.models.Course;
import com.languajesignalgroup.lsm_web.models.Lesson;
import com.languajesignalgroup.lsm_web.repository.CourseRepository;
import com.languajesignalgroup.lsm_web.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl  implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map((course) -> mapToCourseDto(course)).collect(Collectors.toList());
    }

    private CourseDto mapToCourseDto(Course course){
        CourseDto courseDto = CourseDto.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .courseCover(course.getCourseCover())
                .build();
        return courseDto;
    }
}
