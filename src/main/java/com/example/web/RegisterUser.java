package com.example.web;

import com.example.web.dao.UserDao;
import com.example.web.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterUser", value = "/RegisterUser")
public class RegisterUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();

        String name = request.getParameter("name");
        String role = request.getParameter("role");
//      In a production application passwords would be hashed before being saved
        String password = request.getParameter("password");

        User user = new User(name, role, password);
        userDao.createUser(user);

        // Run user through validation to get user's id from database
        User validUser = userDao.validateUser(name, password);

        session.setAttribute("user", validUser);

        if (validUser.getRole().equals("admin")) {
            // Call PopulateAdminDashboardServlet
            RequestDispatcher dispatcher = request.getRequestDispatcher("PopulateAdminDashboard");
            dispatcher.forward(request, response);
        } else if (validUser.getRole().equals("instructor")) {
            // Call PopulateInstructorDashboardServlet
            RequestDispatcher dispatcher = request.getRequestDispatcher("PopulateInstructorDashboard");
            dispatcher.forward(request, response);
        } else if (validUser.getRole().equals("student")) {
            // Call PopulateStudentDashboardServlet
            RequestDispatcher dispatcher = request.getRequestDispatcher("PopulateStudentDashboard");
            dispatcher.forward(request, response);
        }
    }
}
