package com.example.web.dao;

import com.example.web.model.Course;

public class CourseDao {
    public Course getCourse(int id) {
        Course course = new Course();
        course.setId(101);
        course.setName("Enterprise Java");
        course.setInstructorId(1);
        return course;
    }
}
