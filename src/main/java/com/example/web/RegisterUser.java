package com.example.web;

import com.example.dao.UserDao;
import com.example.models.User;
import com.example.utils.PasswordUtils;

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
        PasswordUtils passwordUtils = new PasswordUtils();

        // Get user details from params
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String password = request.getParameter("password");

        // Hash password before saving
        byte[] salt = "Here goes nothing".getBytes();
        String hashedPassword = passwordUtils.hashPassword(password, salt);
        User user = new User(name, role, hashedPassword);

        // Save user to database
        userDao.createUser(user);

        // Run user through validation to get user's id from database
        User validUser = userDao.validateUser(name, password);

        // Set user into session
        session.setAttribute("user", validUser);

        // Redirect based off user's role
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
