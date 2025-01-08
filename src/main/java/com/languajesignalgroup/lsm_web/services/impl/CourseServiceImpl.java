package com.languajesignalgroup.lsm_web.services.impl;

import com.languajesignalgroup.lsm_web.dto.CourseDto;
import com.languajesignalgroup.lsm_web.models.Course;
import com.languajesignalgroup.lsm_web.models.Enrollment;
import com.languajesignalgroup.lsm_web.models.Lesson;
import com.languajesignalgroup.lsm_web.repository.CourseRepository;
import com.languajesignalgroup.lsm_web.repository.UserRepository;
import com.languajesignalgroup.lsm_web.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl  implements CourseService {

    private CourseRepository courseRepository;
    private UserRepository userRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository){
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CourseDto> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map((course) -> mapToCourseDto(course)).collect(Collectors.toList());
    }

    @Override
    public Course saveCourse(CourseDto courseDto) {
        String u
    }

    @Override
    public  void delete(Long courseId){
        courseRepository.deleteById(courseId);
    }

    private CourseDto mapToCourseDto(Course course){
        CourseDto courseDto = CourseDto.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .courseCover(course.getCourseCover())
                .courseDescription(course.getCourseDescription())
                .userId(course.getUser().getUserId())
                .categoryId(course.getCategory().getCategoryId())
                .creationDate(course.getCreationDate())
                .updatedOn(course.getUpdatedOn())
                .lessons(course.getLessons().stream().map((lesson) -> mapToLessonDto(lesson)).collect(Collectors.toList())
                .enrollments(course.getEnrollments().stream().map(Enrollment::getEnrollmentId).collect(Collectors.toList()))
                .build();
        return courseDto;
    }
}
