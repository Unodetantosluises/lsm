package com.languajesignalgroup.lsm_web.controller;

import com.languajesignalgroup.lsm_web.dto.CourseDto;
import com.languajesignalgroup.lsm_web.models.Course;
import com.languajesignalgroup.lsm_web.services.CourseService;
import com.languajesignalgroup.lsm_web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CourseController {
    private CourseService courseService;
    private UserService userService;

    @Autowired
    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping("/courses")
    public String listCourses(Model model){
        List<CourseDto> courses = courseService.findAllCourses();
        model.addAttribute("courses", courses);
        return "courses-list";
    }

    @GetMapping("/courses/new")
    public String createCourseForm(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "courses-create";
    }

    @GetMapping("/courses/{courseId}/delete")
    public String deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.delete(courseId);
        return "redirect:/courses";
    }
}
