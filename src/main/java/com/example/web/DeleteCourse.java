package com.example.web;

import com.example.web.dao.CourseDao;
import com.example.web.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteCourse", value = "/DeleteCourse")
public class DeleteCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao courseDao = new CourseDao();
        HttpSession session = request.getSession();

        // Find and delete course
        int id = Integer.parseInt(request.getParameter("id"));
        courseDao.deleteCourse(id);

        // Set updated courses into session
        session.setAttribute("courses", courseDao.getAllCourses());

        // Get current user
        User user = (User) session.getAttribute("user");

        if (user.getRole().equals("admin")) {
            response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
        } else if (user.getRole().equals("instructor")) {
            response.sendRedirect(request.getContextPath() + "/instructorDashboard.jsp");
        }
    }
}

