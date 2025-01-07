package com.languajesignalgroup.lsm_web.repository;

import com.languajesignalgroup.lsm_web.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // To find Course by Category
    //Optional<Course> findByCategory(String category);

    // To find Course by Name
    Optional<Course> findByCourseName(String courseName);

    // To find all the courses created by a user
    List<Course> findByUser_UserId(Long userId);

    // To find course in the search bar
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
}
