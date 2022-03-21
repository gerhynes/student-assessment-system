package com.example.web;

import com.example.web.dao.AssessmentCriteriaDao;
import com.example.web.dao.CourseDao;
import com.example.web.dao.StudentAssessmentDao;
import com.example.web.models.AssessmentCriteria;
import com.example.web.models.Course;
import com.example.web.models.StudentAssessment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PopulateStudentDashboard", value = "/PopulateStudentDashboard")
public class PopulateStudentDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get courses
        CourseDao courseDao = new CourseDao();
        ArrayList<Course> courses = courseDao.getAllCourses();

        // Get student assessments
        StudentAssessmentDao studentAssessmentDao = new StudentAssessmentDao();
        ArrayList<StudentAssessment> assessments = studentAssessmentDao.getAllStudentAssessments();


        HttpSession session = request.getSession();
        session.setAttribute("courses", courses);
        session.setAttribute("assessments", assessments);

        response.sendRedirect(request.getContextPath() + "/studentDashboard.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
