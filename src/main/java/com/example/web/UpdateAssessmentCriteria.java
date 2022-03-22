package com.example.web;

import com.example.web.dao.AssessmentCriteriaDao;
import com.example.web.dao.CourseDao;
import com.example.web.models.AssessmentCriteria;
import com.example.web.models.Course;
import com.example.web.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdateAssessmentCriteria", value = "/UpdateAssessmentCriteria")
public class UpdateAssessmentCriteria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AssessmentCriteriaDao assessmentCriteriaDao = new AssessmentCriteriaDao();
        HttpSession session = request.getSession();

        // Get form inputs and use to update assessment criteria
        int id = Integer.parseInt(request.getParameter("id"));
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

        // Update record with new assessment criteria
        AssessmentCriteria assessmentCriteria = new AssessmentCriteria(id, courseId, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, finalExam);
        assessmentCriteriaDao.updateAssessmentCriteria(assessmentCriteria);

        // Set updated criteria into session
        session.setAttribute("criteria", assessmentCriteriaDao.getAllAssessmentCriteria());

        response.sendRedirect(request.getContextPath() + "/instructorDashboard.jsp");
    }
}
