package com.example.web;

import com.example.dao.CourseDao;
import com.example.dao.UserDao;
import com.example.models.Course;
import com.example.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PopulateAdminDashboard", value = "/PopulateAdminDashboard")
public class PopulateAdminDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao courseDao = new CourseDao();
        UserDao userDao = new UserDao();

        // Get all courses and users (filter users for instructors in jsp)
        ArrayList<Course> courses = courseDao.getAllCourses();
        ArrayList<User> users = userDao.getAllUsers();

        // Set courses and users into session
        HttpSession session = request.getSession();
        session.setAttribute("courses", courses);
        session.setAttribute("users", users);

        response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
    }
}
