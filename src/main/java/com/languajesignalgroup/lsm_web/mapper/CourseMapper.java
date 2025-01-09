package com.languajesignalgroup.lsm_web.mapper;

import com.languajesignalgroup.lsm_web.dto.CourseDto;
import com.languajesignalgroup.lsm_web.models.Course;
import com.languajesignalgroup.lsm_web.models.Enrollment;

import java.util.stream.Collectors;

import static com.languajesignalgroup.lsm_web.mapper.LessonMapper.mapToLessonDto;

public class CourseMapper {
    public static Course mapToCourse(CourseDto course) {
        Course courseDto = Course.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .courseCover(course.getCourseCover())
                .courseDescription(course.getCourseDescription())
                .creationDate(course.getCreationDate())
                .updatedOn(course.getUpdatedOn())
                .build();
        return courseDto;
    }

    public static CourseDto mapToCourseDto(Course course) {
        CourseDto courseDto = CourseDto.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .courseCover(course.getCourseCover())
                .courseDescription(course.getCourseDescription())
                .categoryId(course.getCategory().getCategoryId())
                .creationDate(course.getCreationDate())
                .updatedOn(course.getUpdatedOn())
                .lesson(course.getLessons().stream().map((lesson) -> mapToLessonDto(lesson)).collect(Collectors.toList()))
                .enrollments(course.getEnrollments().stream().map(Enrollment::getEnrollmentId).collect(Collectors.toList()))
                .build();
        return courseDto;
    }
}
