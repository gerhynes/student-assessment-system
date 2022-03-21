package com.example.web;

import com.example.web.dao.CourseDao;
import com.example.web.models.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/")
public class CourseServlet extends HttpServlet {
    private CourseDao courseDao;

    public void init(){
        courseDao = new CourseDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getServletPath();
        try {
            switch (action){
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/create":
                    createCourse(request, response);
                    break;
                case "/delete":
                    deleteCourse(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCourse(request, response);
                    break;
                default:
                    System.out.println("Default action");
                    listCourses(request, response);
                    break;
            }
        } catch (Exception e){
            throw new ServletException(e);
        }
    }

    private void listCourses(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        ArrayList<Course> courses = courseDao.getAllCourses();
        request.setAttribute("courses", courses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("courseForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Course existingCourse = courseDao.getCourse(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("courseForm.jsp");
        request.setAttribute("course", existingCourse);
        dispatcher.forward(request, response);
    }

    private void createCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String courseCode = request.getParameter("courseCode");
        String name = request.getParameter("name");
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
        Course newCourse = new Course(courseCode, name, instructorId, semester, assessmentId);
        courseDao.createCourse(newCourse);
        response.sendRedirect("adminDashboard.jsp");
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String courseCode = request.getParameter("courseCode");
        String name = request.getParameter("name");
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        int semester = Integer.parseInt(request.getParameter("semester"));
        int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
        Course updatedCourse = new Course(id, courseCode, name, instructorId, semester, assessmentId);
        courseDao.updateCourse(updatedCourse);
        response.sendRedirect("adminDashboard.jsp");
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        courseDao.deleteCourse(id);
        response.sendRedirect("adminDashboard.jsp");
    }
 }
