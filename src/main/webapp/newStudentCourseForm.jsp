<%@ page import="com.example.models.Course" %>
<%@ page import="com.example.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Assessment System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses");
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
        <div>
            <form class="mb-0" action="LogoutUser" method="post">
                <button type="submit" class="btn btn-light">Log Out</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row mb-5">
        <div class="col-md-6 mx-auto">
            <h2>Register for Course</h2>
            <form action="CreateStudentCourse" method="post">
                <div class="mb-3">
                    <label for="studentId">Student ID</label>
                    <input class="form-control" name="studentId" type="text" id="studentId" value="<%= user.getId() %>" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="courseId" class="form-label">Course</label>
                    <select class="form-select" name="courseId" id="courseId" aria-describedby="courseHelp">
                        <option selected>Select a Course</option>
                        <%
                            for (Course singleCourse : courses) {
                                out.print("<option value=\"" + singleCourse.getId() + "\">" + singleCourse.getCourseCode() + " " + singleCourse.getName() + "</option>");
                            }
                        %>
                    </select>
                    <div id="courseHelp" class="form-text">Select from available courses</div>
                </div>
                <div class="mb-3 d-grid">
                    <button class="btn btn-primary" type="submit">
                        Register
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
