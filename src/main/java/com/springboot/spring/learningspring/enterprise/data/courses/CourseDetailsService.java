package com.springboot.spring.learningspring.enterprise.data.courses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
@ComponentScan("com.springboot.spring.learningspring.enterprise.data.courses")
public class CourseDetailsService {
    // course -1
    // course all course details
    // course findById(int id)
    // List<Course> findAll()
    // Course deleteById(int id)

    public enum Status {
        SUCCESS, FAILURE
    }

    @Autowired
    private static List<Course> courses = new ArrayList<>();
    static {
        Course course1 = new Course(1, "Spring", "10 Steps");
        Course course2 = new Course(2, "Spring MVS", "10 Examples");
        Course course3 = new Course(3, "Spring Boot", "6K Students");
        Course course4 = new Course(4, "Maven", "Most popular Maven course");
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
    }

    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    public List<Course> findAll() {
        return courses;
    }

    public Status deleteById(int id) {
        // Using an interator to avoid concurrentModificationException
        Iterator<Course> it = courses.iterator();
        while (it.hasNext()) {
            Course c = it.next();
            if (c.getId() == id) {
                courses.remove(c);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
}
