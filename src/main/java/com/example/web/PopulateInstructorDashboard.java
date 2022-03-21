package com.example.web;

import com.example.web.dao.AssessmentCriteriaDao;
import com.example.web.dao.CourseDao;
import com.example.web.dao.UserDao;
import com.example.web.models.AssessmentCriteria;
import com.example.web.models.Course;
import com.example.web.models.User;

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
        // Get courses
        CourseDao courseDao = new CourseDao();
        ArrayList<Course> courses = courseDao.getAllCourses();

        // Get assessment criteria
        AssessmentCriteriaDao assessmentCriteriaDao = new AssessmentCriteriaDao();
        ArrayList<AssessmentCriteria> criteria = assessmentCriteriaDao.get
        // Get student assessments




        HttpSession session = request.getSession();
        session.setAttribute("courses", courses);


        response.sendRedirect(request.getContextPath() + "/instructorDashboard.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
