package com.springboot.spring.learningspring.enterprise.data.courses;

public class Course {
    int id;
    String name;
    String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Course(int i, String name, String description){
        this.id = i;
        this.name = name;
        this.description = description;

        

    }
}
