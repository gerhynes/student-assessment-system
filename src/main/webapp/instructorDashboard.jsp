<%@ page import="com.example.web.models.User" %>
<%@ page import="com.example.web.models.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web.models.AssessmentCriteria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    ArrayList<AssessmentCriteria> criteria = (ArrayList<AssessmentCriteria>) session.getAttribute("criteria");
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
            <h2>Your Current Courses</h2>
            <p>An ID of 0 means an assessment criteria has not been assigned to the course.</p>
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course ID</th>
                    <th scope="col" class="align-top">Course Code</th>
                    <th scope="col" class="align-top">Course Name</th>
                    <th scope="col" class="align-top">Semester</th>
                    <th scope="col" class="align-top">Assessment Criteria ID</th>
                    <th scope="col" class="align-top">Edit Course</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Course course : courses) {
                        if (course.getInstructorId() == user.getId()) {
                            out.print("<tr>\n" +
                                    "<th scope=\"row\">" + course.getId() + "</th>\n" +
                                    "<td>" + course.getCourseCode() + "</td>\n" +
                                    "<td>" + course.getName() + "</td>\n" +
                                    "<td>" + course.getSemester() + "</td>\n" +
                                    "<td>" + course.getAssessmentId() + "</td>\n" +
                                    "<td>\n" +
                                    "<form action=\"PopulateCourseForm\" method=\"post\">" +
                                    "<input type=\"hidden\" name=\"id\" value=\"" + course.getId() + "\"/>" +
                                    "<button class=\"btn btn-sm btn-primary\" type=\"submit\">Edit</button>\n" +
                                    "</form>" +
                                    "</td>\n" +
                                    "</tr>");
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mx-auto">
            <h2>Assessment Criteria</h2>
            <div class="mb-3">
                <a href="newAssessmentCriteriaForm.jsp" class="btn btn-primary">Create Assessment Criteria</a>
            </div>
            <table class="table table-bordered table-responsive">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course ID</th>
                    <th scope="col" class="align-top">Assessment Criteria ID</th>
                    <th scope="col" colspan="5" class="align-top">Quizzes</th>
                    <th scope="col" colspan="3" class="align-top">Assignments</th>
                    <th scope="col" class="align-top">Midterm Exam</th>
                    <th scope="col" class="align-top">Final Exam</th>
                    <th scope="col" class="align-top">Total</th>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>Q1</td>
                    <td>Q2</td>
                    <td>Q3</td>
                    <td>Q4</td>
                    <td>Q5</td>
                    <td>A1</td>
                    <td>A2</td>
                    <td>A3</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>

                <%
                    for (AssessmentCriteria singleCriteria : criteria) {
                        for (Course singleCourse : courses) {
                            if (singleCriteria.getCourseId() == singleCourse.getId() && singleCourse.getInstructorId() == user.getId()) {
                                out.print("<tr>\n" +
                                        "<th scope=\"row\">" + singleCriteria.getCourseId() + "</th>\n" +
                                        "<td>" + singleCriteria.getId() + "</td>\n" +
                                        "<td>" + singleCriteria.getQuiz1() + "</td>\n" +
                                        "<td>" + singleCriteria.getQuiz2() + "</td>\n" +
                                        "<td>" + singleCriteria.getQuiz3() + "</td>\n" +
                                        "<td>" + singleCriteria.getQuiz4() + "</td>\n" +
                                        "<td>" + singleCriteria.getQuiz5() + "</td>\n" +
                                        "<td>" + singleCriteria.getAssignment1() + "</td>\n" +
                                        "<td>" + singleCriteria.getAssignment2() + "</td>\n" +
                                        "<td>" + singleCriteria.getAssignment3() + "</td>\n" +
                                        "<td>" + singleCriteria.getMidterm() + "</td>\n" +
                                        "<td>" + singleCriteria.getFinalExam() + "</td>\n" +
                                        "<td>100</td>" +
                                        "</tr>");
                            }
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
