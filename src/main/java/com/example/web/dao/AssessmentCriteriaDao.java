package com.example.web.dao;

import com.example.web.models.AssessmentCriteria;
import com.example.web.models.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AssessmentCriteriaDao {
    public AssessmentCriteria getAssessmentCriteria(int criteriaId) {
        AssessmentCriteria assessmentCriteria =  null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_assessment","root","thomasmerton");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM assessment_criteria WHERE id =" + criteriaId);
            if(resultSet.next()) {
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
        } catch(Exception e) {
            System.out.println(e);
        }
        return assessmentCriteria;
    }
}
