package com.springboot.spring.learningspring;

public class Course {
    int id;
    String name;
    String author;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Course(int i, String name, String author){
        this.id = i;
        this.name = name;
        this.author = author;

        

    }
}
