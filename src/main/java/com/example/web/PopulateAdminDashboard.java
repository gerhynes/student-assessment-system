package com.example.web;

import com.example.web.dao.CourseDao;
import com.example.web.dao.UserDao;
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

@WebServlet(name = "PopulateAdminDashboard", value = "/PopulateAdminDashboard")
public class PopulateAdminDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao courseDao = new CourseDao();
        UserDao userDao = new UserDao();
        ArrayList<Course> courses = courseDao.getAllCourses();
        ArrayList<User> users = userDao.getAllUsers();

        HttpSession session = request.getSession();
        session.setAttribute("courses", courses);
        session.setAttribute("users", users);

        response.sendRedirect(request.getContextPath() + "/adminDashboard.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
