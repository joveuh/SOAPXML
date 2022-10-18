package com.springboot.spring.learningspring.enterprise.data.courses;

public class Course{
    private int id;
    private String name;
    private String description;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Course(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
