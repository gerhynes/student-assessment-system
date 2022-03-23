package com.example.web;

import com.example.dao.UserDao;
import com.example.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginUser", value = "/LoginUser")
public class LoginUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();

        String username = request.getParameter("name");
        String password = request.getParameter("password");

        // Validate user
        User validUser = userDao.validateUser(username, password);

        // Set user into session
        session.setAttribute("user", validUser);

        // Redirect based off user's role
        if (validUser.getRole().equals("admin")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("PopulateAdminDashboard");
            dispatcher.forward(request, response);
        } else if (validUser.getRole().equals("instructor")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("PopulateInstructorDashboard");
            dispatcher.forward(request, response);
        } else if (validUser.getRole().equals("student")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("PopulateStudentDashboard");
            dispatcher.forward(request, response);
        } else if (validUser == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}

