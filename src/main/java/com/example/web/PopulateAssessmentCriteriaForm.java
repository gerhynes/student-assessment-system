package com.example.web;

import com.example.web.dao.AssessmentCriteriaDao;
import com.example.web.dao.CourseDao;
import com.example.web.models.AssessmentCriteria;
import com.example.web.models.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PopulateAssessmentCriteriaForm", value = "/PopulateAssessmentCriteriaForm")
public class PopulateAssessmentCriteriaForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AssessmentCriteriaDao assessmentCriteriaDao = new AssessmentCriteriaDao();


        int id = Integer.parseInt(request.getParameter("id"));

        AssessmentCriteria assessmentCriteria = assessmentCriteriaDao.getAssessmentCriteria(id);

        session.setAttribute("currentCriteria", assessmentCriteria);

        response.sendRedirect(request.getContextPath() + "/editAssessmentCriteriaForm.jsp");
    }
}

