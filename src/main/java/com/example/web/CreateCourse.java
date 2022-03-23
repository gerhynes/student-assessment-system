package com.example.web;

import com.example.dao.CourseDao;
import com.example.models.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateCourse", value = "/CreateCourse")
public class CreateCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao courseDao = new CourseDao();
        HttpSession session = request.getSession();

        // Get form inputs and use to create course
        String courseCode = request.getParameter("courseCode");
        String name = request.getParameter("name");
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));

        Course course = new Course(courseCode, name, instructorId, semester, assessmentId);
        courseDao.createCourse(course);

        // Set updated courses into session
        session.setAttribute("courses", courseDao.getAllCourses());

        response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
    }
}

