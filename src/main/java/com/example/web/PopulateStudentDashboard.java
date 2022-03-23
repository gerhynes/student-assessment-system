package com.example.web;

import com.example.dao.CourseDao;
import com.example.dao.StudentAssessmentDao;
import com.example.dao.StudentCourseDao;
import com.example.models.Course;
import com.example.models.StudentAssessment;
import com.example.models.StudentCourse;

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

        // Get courses, student assessments and student courses (filter in jsp)
        ArrayList<Course> courses = courseDao.getAllCourses();
        ArrayList<StudentAssessment> assessments = studentAssessmentDao.getAllStudentAssessments();
        ArrayList<StudentCourse> studentCourses = studentCourseDao.getAllStudentCourses();

        // Set into session
        session.setAttribute("courses", courses);
        session.setAttribute("studentAssessments", assessments);
        session.setAttribute("studentCourses", studentCourses);

        response.sendRedirect(request.getContextPath() + "/studentDashboard.jsp");
    }
}
