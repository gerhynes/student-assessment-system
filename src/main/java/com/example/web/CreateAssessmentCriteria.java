package com.example.web;

import com.example.dao.AssessmentCriteriaDao;
import com.example.dao.CourseDao;
import com.example.models.AssessmentCriteria;
import com.example.models.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CreateAssessmentCriteria", value = "/CreateAssessmentCriteria")
public class CreateAssessmentCriteria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AssessmentCriteriaDao assessmentCriteriaDao = new AssessmentCriteriaDao();
        CourseDao courseDao = new CourseDao();

        // Get form inputs and use to create assessment criteria
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

        // Create and save new assessment criteria
        AssessmentCriteria newAssessmentCriteria = new AssessmentCriteria(courseId, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1, assignment2, assignment3, midterm, finalExam);
        assessmentCriteriaDao.createAssessmentCriteria(newAssessmentCriteria);

        // Update course with new assessmentId
        Course course = courseDao.getCourse(courseId);
        ArrayList<AssessmentCriteria> criteria = assessmentCriteriaDao.getAllAssessmentCriteria();
        for (AssessmentCriteria singleCriteria : criteria) {
            if (singleCriteria.getCourseId() == course.getId()) {
                course.setAssessmentId(singleCriteria.getId());
                courseDao.updateCourse(course);
            }
        }

        // Set updated criteria and courses into session
        session.setAttribute("criteria", assessmentCriteriaDao.getAllAssessmentCriteria());
        session.setAttribute("courses", courseDao.getAllCourses());

        response.sendRedirect(request.getContextPath() + "/instructorDashboard.jsp");
    }
}

