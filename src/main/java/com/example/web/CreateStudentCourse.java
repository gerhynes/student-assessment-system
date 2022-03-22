package com.example.web;

import com.example.web.dao.StudentCourseDao;
import com.example.web.models.StudentCourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateStudentCourse", value = "/CreateStudentCourse")
public class CreateStudentCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentCourseDao studentCourseDao = new StudentCourseDao();
        HttpSession session = request.getSession();

        // Get form inputs and use to create new StudentCourse
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        StudentCourse studentCourse = new StudentCourse(studentId, courseId);
        studentCourseDao.createStudentCourse(studentCourse);

        // Set updated courses into session
        session.setAttribute("studentCourses", studentCourseDao.getAllStudentCourses());

        response.sendRedirect(request.getContextPath() + "/studentDashboard.jsp");
    }
}

