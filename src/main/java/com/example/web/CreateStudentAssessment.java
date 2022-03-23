package com.example.web;

import com.example.dao.StudentAssessmentDao;
import com.example.models.StudentAssessment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateStudentAssessment", value = "/CreateStudentAssessment")
public class CreateStudentAssessment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StudentAssessmentDao studentAssessmentDao  = new StudentAssessmentDao();

        // Get form inputs and use to create new student assessment
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int quiz1 = Integer.parseInt(request.getParameter("quiz1"));
        int quiz2 = Integer.parseInt(request.getParameter("quiz2"));
        int quiz3 = Integer.parseInt(request.getParameter("quiz3"));
        int quiz4 = Integer.parseInt(request.getParameter("quiz4"));
        int quiz5 = Integer.parseInt(request.getParameter("quiz5"));
        int assignment1 = Integer.parseInt(request.getParameter("assignment1"));
        int assignment2 = Integer.parseInt(request.getParameter("assignment2"));
        int assignment3 = Integer.parseInt(request.getParameter("assignment3"));
        int midterm = Integer.parseInt(request.getParameter("midterm"));
        int finalExam = Integer.parseInt(request.getParameter("finalExam"));

        // Create and save new student assessment
        StudentAssessment studentAssessment = new StudentAssessment(studentId, courseId, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, finalExam);
        studentAssessmentDao.createStudentAssessment(studentAssessment);

        // Set updated assessments into session
        session.setAttribute("studentAssessments", studentAssessmentDao.getAllStudentAssessments());

        response.sendRedirect(request.getContextPath() + "/instructorDashboard.jsp");
    }
}

