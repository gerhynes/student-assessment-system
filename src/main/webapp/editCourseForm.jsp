<%@ page import="com.example.web.models.Course" %>
<%@ page import="com.example.web.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Course Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    Course course = (Course) session.getAttribute("currentCourse");
%>
<nav class="navbar navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <h1>
            <a class="navbar-brand" href="/student-assessment-system">Student Assessment</a>
        </h1>
        <div>
            <span class="navbar-text">
            <% out.print("ID: " + user.getId() + ""); %>
            </span>
            <span class="navbar-text">
            <% out.print(user.getName()); %>
            </span>
            <span class="navbar-text">
            <% out.print("(" + user.getRole() + ")"); %>
            </span>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="text-center mt-5 mb-5">Student Assessment System</h1>
    <div class="row mb-5">
        <div class="col-md-6 mx-auto">
            <h2>Edit Course</h2>
            <form action="UpdateCourse" method="post">
                <input type="hidden" name="id" value="<%= course.getId() %>"/>
                <div class="mb-3">
                    <label for="courseCode">Course Code</label>
                    <input class="form-control" name="courseCode" type="text"
                           value="<%= course.getCourseCode() %>" id="courseCode" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="name">Course Name</label>
                    <input class="form-control" name="name" type="text"
                           value="<%= course.getName() %>" id="name" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="instructorId">Instructor ID</label>
                    <input class="form-control" name="instructorId" type="text"
                           value="<%= course.getInstructorId() %>" id="instructorId"/>
                </div>
                <div class="mb-3">
                    <label for="semester">Semester</label>
                    <input class="form-control" name="semester" type="text"
                           value="<%= course.getSemester() %>" id="semester" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="assessmentId">Assessment ID</label>
                    <input class="form-control" name="assessmentId" type="text"
                           value="<%= course.getAssessmentId() %>" id="assessmentId"/>
                </div>
                <div class="mb-3 d-grid">
                    <button class="btn btn-primary" type="submit">
                        Save
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>