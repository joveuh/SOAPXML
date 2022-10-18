package com.springboot.spring.learningspring.enterprise.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring.learningspring.enterprise.data.courses.Course;

 
@RestController
@Component
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> outputAllCourses(){
        return Arrays.asList(
            new Course(1, "course1", "uzair"),
            new Course(2, "course2", "uzair"),
            new Course(3, "course3", "uzair")
        );
    }
}
