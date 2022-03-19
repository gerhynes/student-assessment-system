package com.example.web.model;

public class Course {
    private int id;
    private String name;
    private int instructorId;

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

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    @Override
    public String toString() {
        return "Course id=" + id + ", name=" + name + ", instructor_id=" + instructorId;
    }
}
