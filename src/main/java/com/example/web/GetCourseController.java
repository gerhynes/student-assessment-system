package com.example.web;

import com.example.web.dao.CourseDao;
import com.example.web.models.Course;

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

        HttpSession session = request.getSession();
        session.setAttribute("course", course);

        response.sendRedirect("showCourse.jsp");
    }
}
