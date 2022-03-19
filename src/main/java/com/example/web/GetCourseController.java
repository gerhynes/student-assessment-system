package com.example.web;

import com.example.web.dao.CourseDao;
import com.example.web.model.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetCourseController", value = "/GetCourseController")
public class GetCourseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        CourseDao dao = new CourseDao();
        Course course = dao.getCourse(courseId);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("showCourse.jsp");
        requestDispatcher.forward(request, response);
    }
}
