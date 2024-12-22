package com.languajesignalgroup.lsm_web.repository;

import com.languajesignalgroup.lsm_web.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseName(String courseName);
}
