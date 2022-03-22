package com.example.web;

import com.example.web.dao.AssessmentCriteriaDao;
import com.example.web.dao.CourseDao;
import com.example.web.dao.StudentAssessmentDao;
import com.example.web.dao.StudentCourseDao;
import com.example.web.models.AssessmentCriteria;
import com.example.web.models.Course;
import com.example.web.models.StudentAssessment;
import com.example.web.models.StudentCourse;

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
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CourseDao courseDao = new CourseDao();
        StudentAssessmentDao studentAssessmentDao = new StudentAssessmentDao();
        StudentCourseDao studentCourseDao = new StudentCourseDao();

        // Get courses
        ArrayList<Course> courses = courseDao.getAllCourses();

        // Get student assessments
        ArrayList<StudentAssessment> assessments = studentAssessmentDao.getAllStudentAssessments();

        // Get registered course
        ArrayList<StudentCourse> studentCourses = studentCourseDao.getAllStudentCourses();

        session.setAttribute("courses", courses);
        session.setAttribute("studentAssessments", assessments);
        session.setAttribute("studentCourses", studentCourses);

        response.sendRedirect(request.getContextPath() + "/studentDashboard.jsp");
    }
}
