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

@WebServlet(name = "PopulateCourseForm", value = "/PopulateCourseForm")
public class PopulateCourseForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CourseDao courseDao = new CourseDao();

        // Get specific course
        int id = Integer.parseInt(request.getParameter("id"));
        Course course = courseDao.getCourse(id);

        // Set course into session
        session.setAttribute("currentCourse", course);

        response.sendRedirect(request.getContextPath() + "/editCourseForm.jsp");
    }
}

