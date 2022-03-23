package com.example.web.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.web.models.Course;
import com.example.web.models.StudentCourse;

public class StudentCourseDao {

    protected Connection getConnection() {
        Connection connection = null;
        String dbUrl = "jdbc:mysql://localhost:3306/student_assessment";
        String dbUser = "root";
        String dbPassword = "thomasmerton";
        // String dbPassword = "rootpasswordgiven";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public StudentCourse getStudentCourse(int studentCourseId) {
        StudentCourse studentCourse = null;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student_courses WHERE id = " + studentCourseId);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int studentId = resultSet.getInt("student_id");
                int courseId = resultSet.getInt("course_id");
                studentCourse = new StudentCourse(id, studentId, courseId);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentCourse;
    }

    public ArrayList<StudentCourse> getAllStudentCourses() {
        ArrayList<StudentCourse> studentCourses = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student_courses;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int studentId = resultSet.getInt("student_id");
                int courseId = resultSet.getInt("course_id");
                studentCourses.add(new StudentCourse(id, studentId, courseId));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentCourses;
    }

    public void createStudentCourse(StudentCourse studentCourse) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            int studentId = studentCourse.getStudentId();
            int courseId = studentCourse.getCourseId();
            statement.executeUpdate("INSERT INTO student_courses (student_id, course_id) VALUES (" + studentId + "," + courseId + ");");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean updateStudentCourse(StudentCourse studentCourse) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            int id = studentCourse.getId();
           int studentId = studentCourse.getStudentId();
           int courseId = studentCourse.getCourseId();
            rowUpdated = statement.executeUpdate("UPDATE student_courses SET id = " + id +
                    ", student_id = " + studentId +
                    ", course_id = " + courseId +
                    " WHERE id = " + id) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowUpdated;
    }

    public boolean deleteStudentCourse(int studentCourseId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            rowDeleted = statement.executeUpdate("DELETE FROM student_courses WHERE id = " + studentCourseId) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowDeleted;
    }
}
