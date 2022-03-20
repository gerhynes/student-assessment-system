package com.example.web.dao;

import java.sql.*;
import com.example.web.models.Course;

public class CourseDao {

    public Course getCourse(int id) {
        Course course = new Course();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_assessment","root","thomasmerton");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses WHERE id =" + id);
            if(resultSet.next()) {
                course.setId(resultSet.getInt("id"));
                course.setCourseCode(resultSet.getString("course_code"));
                course.setName(resultSet.getString("name"));
                course.setInstructorId(resultSet.getInt("instructor_id"));
                course.setSemester(resultSet.getInt("semester"));
                course.setAssessmentId(resultSet.getInt("assessment_id"));
            }
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return course;
    }
}
