package com.example.web;

import com.example.dao.CourseDao;
import com.example.models.Course;
import com.example.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdateCourse", value = "/UpdateCourse")
public class UpdateCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao courseDao = new CourseDao();
        HttpSession session = request.getSession();

        // Get form inputs and use to update course
        int id = Integer.parseInt(request.getParameter("id"));
        String courseCode = request.getParameter("courseCode");
        String name = request.getParameter("name");
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));

        Course course = new Course(id, courseCode, name, instructorId, semester, assessmentId);
        courseDao.updateCourse(course);

        // Set updated courses into session
        session.setAttribute("courses", courseDao.getAllCourses());

        // Get current user
        User user = (User) session.getAttribute("user");

        // Redirect based off user's role
        if (user.getRole().equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
        } else if (user.getRole().equals("instructor")) {
            response.sendRedirect(request.getContextPath() + "/instructorDashboard.jsp");
        }
    }
}

