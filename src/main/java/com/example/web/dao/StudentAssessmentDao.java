package com.example.web.dao;

import com.example.web.models.StudentAssessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentAssessmentDao {

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

    public ArrayList<StudentAssessment> getAllStudentAssessments() {
        ArrayList<StudentAssessment> assessments = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student_assessments;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int studentId = resultSet.getInt("student_id");
                int courseId = resultSet.getInt("course_id");
                int quiz1 = resultSet.getInt("quiz1");
                int quiz2 = resultSet.getInt("quiz2");
                int quiz3 = resultSet.getInt("quiz3");
                int quiz4 = resultSet.getInt("quiz4");
                int quiz5 = resultSet.getInt("quiz5");
                int assignment1 = resultSet.getInt("assignment1");
                int assignment2 = resultSet.getInt("assignment2");
                int assignment3 = resultSet.getInt("assignment3");
                int midterm = resultSet.getInt("midterm");
                int finalExam = resultSet.getInt("final");
                assessments.add(new StudentAssessment(id, studentId, courseId, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, finalExam));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return assessments;
    }

    public StudentAssessment getStudentAssessment(int assessmentId) {
        StudentAssessment studentAssessment = null;

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student_assessments WHERE id =" + assessmentId);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int studentId = resultSet.getInt("student_id");
                int courseId = resultSet.getInt("course_id");
                int quiz1 = resultSet.getInt("quiz1");
                int quiz2 = resultSet.getInt("quiz2");
                int quiz3 = resultSet.getInt("quiz3");
                int quiz4 = resultSet.getInt("quiz4");
                int quiz5 = resultSet.getInt("quiz5");
                int assignment1 = resultSet.getInt("assignment1");
                int assignment2 = resultSet.getInt("assignment2");
                int assignment3 = resultSet.getInt("assignment3");
                int midterm = resultSet.getInt("midterm");
                int finalExam = resultSet.getInt("final");
                studentAssessment = new StudentAssessment(id, studentId, courseId, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, finalExam);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentAssessment;
    }

    public void createStudentAssessment(StudentAssessment studentAssessment) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();

            int studentId = studentAssessment.getStudentId();
            int courseId = studentAssessment.getCourseId();
            int quiz1 = studentAssessment.getQuiz1();
            int quiz2 = studentAssessment.getQuiz2();
            int quiz3 = studentAssessment.getQuiz3();
            int quiz4 = studentAssessment.getQuiz4();
            int quiz5 = studentAssessment.getQuiz5();
            int assignment1 = studentAssessment.getAssignment1();
            int assignment2 = studentAssessment.getAssignment2();
            int assignment3 = studentAssessment.getAssignment3();
            int midterm = studentAssessment.getMidterm();
            int finalExam = studentAssessment.getFinalExam();

            String sql = "INSERT INTO student_assessments (student_id, course_id, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, final) VALUES ("
                    + studentId +
                    "," + courseId +
                    "," + quiz1 +
                    "," + quiz2 +
                    "," + quiz3 +
                    "," + quiz4 +
                    "," + quiz5 +
                    "," + assignment1 +
                    "," + assignment2 +
                    "," + assignment3 +
                    "," + midterm +
                    "," + finalExam +
                    ");";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean updateStudentAssessment(StudentAssessment studentAssessment) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();

            int id = studentAssessment.getId();
            int studentId = studentAssessment.getStudentId();
            int courseId = studentAssessment.getCourseId();
            int quiz1 = studentAssessment.getQuiz1();
            int quiz2 = studentAssessment.getQuiz2();
            int quiz3 = studentAssessment.getQuiz3();
            int quiz4 = studentAssessment.getQuiz4();
            int quiz5 = studentAssessment.getQuiz5();
            int assignment1 = studentAssessment.getAssignment1();
            int assignment2 = studentAssessment.getAssignment2();
            int assignment3 = studentAssessment.getAssignment3();
            int midterm = studentAssessment.getMidterm();
            int finalExam = studentAssessment.getFinalExam();

            String sql = "UPDATE student_assessments SET student_id = " + studentId +
                    ", course_id = " + courseId +
                    ", quiz1 = " + quiz1 +
                    ", quiz2 = " + quiz2 +
                    ", quiz3 = " + quiz3 +
                    ", quiz4 = " + quiz4 +
                    ", quiz5 = " + quiz5 +
                    ", assignment1 = " + assignment1 +
                    ", assignment2 = " + assignment2 +
                    ", assignment3 = " + assignment3 +
                    ", midterm = " + midterm +
                    ", final = " + finalExam +
                    " WHERE id = " + id;
            System.out.println(sql);
            rowUpdated = statement.executeUpdate(sql) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowUpdated;
    }

    public boolean deleteStudentAssessment(int assessmentId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            rowDeleted = statement.executeUpdate("DELETE FROM student_assessments WHERE id = " + assessmentId) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowDeleted;
    }
}
