package com.example.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.models.Course;

public class CourseDao {

    protected Connection getConnection() {
        Connection connection = null;
        String dbUrl = "jdbc:mysql://localhost:3306/student_assessment";
        String dbUser = "root";
        String dbPassword = "rootpasswordgiven";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            System.out.println("This application attempts to connect to the database using the default MySQl root password.\nIf you are using your own password, update the dbPassword field in the DAO classes.");
            e.printStackTrace();
        }
        return connection;
    }

    public Course getCourse(int courseId) {
        Course course = null;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses WHERE id = " + courseId);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String courseCode = resultSet.getString("course_code");
                String name = resultSet.getString("name");
                int instructorId = resultSet.getInt("instructor_id");
                int semester = resultSet.getInt("semester");
                int assessmentId = resultSet.getInt("assessment_id");
                course = new Course(id, courseCode, name, instructorId, semester, assessmentId);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return course;
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM courses;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String courseCode = resultSet.getString("course_code");
                String name = resultSet.getString("name");
                int instructorId = resultSet.getInt("instructor_id");
                int semester = resultSet.getInt("semester");
                int assessmentId = resultSet.getInt("assessment_id");
                courses.add(new Course(id, courseCode, name, instructorId, semester, assessmentId));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return courses;
    }

    public void createCourse(Course course) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String courseCode = course.getCourseCode();
            String name = course.getName();
            int instructorId = course.getInstructorId();
            int semester = course.getSemester();
            int assessmentId = course.getAssessmentId();
            statement.executeUpdate("INSERT INTO courses (course_code, name, instructor_id, semester, assessment_id) VALUES ('" + courseCode + "','" + name + "'," + instructorId + "," + semester + "," + assessmentId + ");");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean updateCourse(Course course) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            int id = course.getId();
            String courseCode = course.getCourseCode();
            String name = course.getName();
            int instructorId = course.getInstructorId();
            int semester = course.getSemester();
            int assessmentId = course.getAssessmentId();
            rowUpdated = statement.executeUpdate("UPDATE courses SET id = " + id +
                    ", course_code = \'" + courseCode + "\'" +
                    ", name = \'" + name + "\'" +
                    ", instructor_id = " + instructorId +
                    ", semester = " + semester +
                    ", assessment_id = " + assessmentId +
                    " WHERE id = " + id) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowUpdated;
    }

    public boolean deleteCourse(int courseId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            rowDeleted = statement.executeUpdate("DELETE FROM courses WHERE id = " + courseId) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowDeleted;
    }
}
