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

@WebServlet(name = "LoginUser", value = "/LoginUser")
public class LoginUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        String username = request.getParameter("name");
        String password = request.getParameter("password");

        User validUser = userDao.validateUser(username, password);

        HttpSession session = request.getSession();
        session.setAttribute("user", validUser);

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

