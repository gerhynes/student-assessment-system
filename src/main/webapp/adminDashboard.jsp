<%@ page import="com.example.web.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web.models.Course" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");

    ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses");

    ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
%>
<nav class="navbar navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <h1>
            <a class="navbar-brand" href="/student-assessment-system">Student Assessment</a>
        </h1>
        <div>
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
    <div class="row mb-5">
        <div class="col-md-6 mx-auto">
            <h2>Current Courses</h2>
            <p>An ID of 0 means an instructor/assessment criteria has not been assigned to the course.</p>
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course Code</th>
                    <th scope="col" class="align-top">Course Name</th>
                    <th scope="col" class="align-top">Semester</th>
                    <th scope="col" class="align-top">Instructor ID</th>
                    <th scope="col" class="align-top">Assessment Criteria ID</th>
                    <th scope="col" class="align-top">Edit</th>
                    <th scope="col" class="align-top">Delete</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Course course : courses) {
                        out.print("<tr>\n" +
                                "<th scope=\"row\">" + course.getCourseCode() + "</th>\n" +
                                "<td>" + course.getName() + "</td>\n" +
                                "<td>" + course.getSemester() + "</td>\n" +
                                "<td>" + course.getInstructorId() + "</td>\n" +
                                "<td>" + course.getAssessmentId() + "</td>\n" +
                                "<td>\n" +
                                "<form action=\"PopulateCourseForm\" method=\"post\">" +
                                "<input type=\"hidden\" name=\"id\" value=\""+ course.getId() + "\"/>" +
                                "<button class=\"btn btn-sm btn-primary\" type=\"submit\">Edit</button>\n" +
                                "</form>" +
                                "</td>\n" +
                                "<td>\n" +
                                "<form action=\"DeleteCourse\" method=\"post\">" +
                                "<input type=\"hidden\" name=\"id\" value=\""+ course.getId() + "\"/>" +
                                "<button class=\"btn btn-sm btn-primary\" type=\"submit\">Delete</button>\n" +
                                "</form>" +
                                "</td>\n" +
                                "</tr>");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mx-auto">
            <h2>Available Instructors</h2>
            <ul>
                <%
                    for (User singleUser : users) {
                        if (singleUser.getRole().equals("instructor")) {
                            out.print("<li>" + singleUser.getName() + " (ID: " + singleUser.getId() + ")</li>");
                        }
                    }
                %>
            </ul>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>