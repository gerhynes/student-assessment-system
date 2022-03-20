package com.example.web;

import com.example.web.dao.CourseDao;
import com.example.web.models.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetCoursesController", value = "/GetCoursesController")
public class GetCoursesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        CourseDao dao = new CourseDao();
        ArrayList<Course> courses = dao.getAllCourses();

        HttpSession session = request.getSession();
        session.setAttribute("courses", courses);

        response.sendRedirect("showCourses.jsp");
    }
}