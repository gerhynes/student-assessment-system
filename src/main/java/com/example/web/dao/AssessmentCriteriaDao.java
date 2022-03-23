package com.example.web.dao;

import com.example.web.models.AssessmentCriteria;
import com.example.web.models.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AssessmentCriteriaDao {

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

    public ArrayList<AssessmentCriteria> getAllAssessmentCriteria() {
        ArrayList<AssessmentCriteria> criteria = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM assessment_criteria;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
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
                criteria.add(new AssessmentCriteria(id, courseId, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, finalExam));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return criteria;
    }


    public AssessmentCriteria getAssessmentCriteria(int criteriaId) {
        AssessmentCriteria assessmentCriteria = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_assessment", "root", "thomasmerton");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM assessment_criteria WHERE id =" + criteriaId);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
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
                assessmentCriteria = new AssessmentCriteria(id, courseId, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, finalExam);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return assessmentCriteria;
    }

    public void createAssessmentCriteria(AssessmentCriteria assessmentCriteria){
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();

            int courseId = assessmentCriteria.getCourseId();
            int quiz1 = assessmentCriteria.getQuiz1();
            int quiz2 = assessmentCriteria.getQuiz2();
            int quiz3 = assessmentCriteria.getQuiz3();
            int quiz4 = assessmentCriteria.getQuiz4();
            int quiz5 = assessmentCriteria.getQuiz5();
            int assignment1 = assessmentCriteria.getAssignment1();
            int assignment2 = assessmentCriteria.getAssignment2();
            int assignment3 = assessmentCriteria.getAssignment3();
            int midterm = assessmentCriteria.getMidterm();
            int finalExam = assessmentCriteria.getFinalExam();

            String sql = "INSERT INTO assessment_criteria (course_id, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, final ) VALUES (" + courseId +
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

    public boolean updateAssessmentCriteria(AssessmentCriteria assessmentCriteria) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            int id = assessmentCriteria.getId();
            int courseId = assessmentCriteria.getCourseId();
            int quiz1 = assessmentCriteria.getQuiz1();
            int quiz2 = assessmentCriteria.getQuiz2();
            int quiz3 = assessmentCriteria.getQuiz3();
            int quiz4 = assessmentCriteria.getQuiz4();
            int quiz5 = assessmentCriteria.getQuiz5();
            int assignment1 = assessmentCriteria.getAssignment1();
            int assignment2 = assessmentCriteria.getAssignment2();
            int assignment3 = assessmentCriteria.getAssignment3();
            int midterm = assessmentCriteria.getMidterm();
            int finalExam = assessmentCriteria.getFinalExam();

            rowUpdated = statement.executeUpdate("UPDATE assessment_criteria SET course_id = " + courseId +
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
                    " WHERE id = " + id) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowUpdated;
    }

    public boolean deleteAssessmentCriteria(int criteriaId) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            rowDeleted = statement.executeUpdate("DELETE FROM assessment_criteria WHERE id = " + criteriaId) > 0;
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowDeleted;
    }
}
