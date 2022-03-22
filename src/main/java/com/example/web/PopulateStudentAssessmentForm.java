package com.example.web;

import com.example.web.dao.AssessmentCriteriaDao;
import com.example.web.dao.CourseDao;
import com.example.web.dao.StudentAssessmentDao;
import com.example.web.models.AssessmentCriteria;
import com.example.web.models.Course;
import com.example.web.models.StudentAssessment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PopulateStudentAssessmentForm", value = "/PopulateStudentAssessmentForm")
public class PopulateStudentAssessmentForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StudentAssessmentDao studentAssessmentDao = new StudentAssessmentDao();

        int id = Integer.parseInt(request.getParameter("id"));

        StudentAssessment studentAssessment = studentAssessmentDao.getStudentAssessment(id);

        session.setAttribute("currentAssessment", studentAssessment);

        response.sendRedirect(request.getContextPath() + "/editStudentAssessmentForm.jsp");
    }
}

