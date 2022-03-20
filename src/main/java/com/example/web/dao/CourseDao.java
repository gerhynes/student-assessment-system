package com.example.web.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.web.models.Course;

public class CourseDao {

    public Course getCourse(int courseId) {
        Course course = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_assessment","root","thomasmerton");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses WHERE id =" + courseId);
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String courseCode = resultSet.getString("course_code");
                String name = resultSet.getString("name");
                int instructorId = resultSet.getInt("instructor_id");
                int semester = resultSet.getInt("semester");
                int assessmentId = resultSet.getInt("assessment_id");
                course = new Course(id, courseCode, name, instructorId, semester, assessmentId);
            }
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return course;
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_assessment","root","thomasmerton");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String courseCode = resultSet.getString("course_code");
                String name = resultSet.getString("name");
                int instructorId = resultSet.getInt("instructor_id");
                int semester = resultSet.getInt("semester");
                int assessmentId = resultSet.getInt("assessment_id");

                courses.add(new Course(id, courseCode, name, instructorId, semester, assessmentId));
            }
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }

        return courses;
    }
}
