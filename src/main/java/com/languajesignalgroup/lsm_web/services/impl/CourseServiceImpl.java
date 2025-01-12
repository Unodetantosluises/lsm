package com.languajesignalgroup.lsm_web.services.impl;

import com.languajesignalgroup.lsm_web.dto.CourseDto;
import com.languajesignalgroup.lsm_web.models.Course;
import com.languajesignalgroup.lsm_web.models.Users;
import com.languajesignalgroup.lsm_web.repository.CourseRepository;
import com.languajesignalgroup.lsm_web.repository.UserRepository;
import com.languajesignalgroup.lsm_web.services.CourseService;
import com.languajesignalgroup.lsm_web.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.languajesignalgroup.lsm_web.mapper.CourseMapper.mapToCourse;
import static com.languajesignalgroup.lsm_web.mapper.CourseMapper.mapToCourseDto;

@Service
public class CourseServiceImpl implements CourseService {
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
        String userName = SecurityUtil.getSessionUser();
        Users user = userRepository.findByUserName(userName);
        Course course = mapToCourse(courseDto);
        course.setCreatedBy(user);
        return courseRepository.save(course);
    }

    @Override
    public CourseDto findCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return mapToCourseDto(course);
    }

    @Override
    public void updateCourse(CourseDto courseDto) {
        String userName = SecurityUtil.getSessionUser();
        Users user = userRepository.findByUserName(userName);
        Course course = mapToCourse(courseDto);
        course.setCreatedBy(user);
        courseRepository.save(course);
    }

    @Override
    public  void delete(long courseId){
        courseRepository.deleteById(courseId);
    }
}
