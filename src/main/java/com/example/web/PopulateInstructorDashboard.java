package com.example.web;

import com.example.dao.AssessmentCriteriaDao;
import com.example.dao.CourseDao;
import com.example.dao.StudentAssessmentDao;
import com.example.models.AssessmentCriteria;
import com.example.models.Course;
import com.example.models.StudentAssessment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PopulateInstructorDashboard", value = "/PopulateInstructorDashboard")
public class PopulateInstructorDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CourseDao courseDao = new CourseDao();
        AssessmentCriteriaDao assessmentCriteriaDao = new AssessmentCriteriaDao();
        StudentAssessmentDao studentAssessmentDao = new StudentAssessmentDao();

        // Get courses, assessment criteria and student assessments
        ArrayList<Course> courses = courseDao.getAllCourses();
        ArrayList<AssessmentCriteria> criteria = assessmentCriteriaDao.getAllAssessmentCriteria();
        ArrayList<StudentAssessment> assessments = studentAssessmentDao.getAllStudentAssessments();

        // Set them into session
        session.setAttribute("courses", courses);
        session.setAttribute("criteria", criteria);
        session.setAttribute("studentAssessments", assessments);

        response.sendRedirect(request.getContextPath() + "/instructorDashboard.jsp");
    }
}
