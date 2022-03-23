<%@ page import="com.example.web.models.User" %>
<%@ page import="com.example.web.models.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web.models.AssessmentCriteria" %>
<%@ page import="com.example.web.models.StudentAssessment" %>
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

    ArrayList<StudentAssessment> assessments = (ArrayList<StudentAssessment>) session.getAttribute("studentAssessments");
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
    <section class="row mb-5">
        <div class="col-md-9 col-lg-8 mx-auto">
            <h2>Your Current Courses</h2>
            <div class="alert alert-info d-flex align-items-center" role="alert">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-info-circle-fill flex-shrink-0 me-2" viewBox="0 0 16 16">
                    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                </svg>
                <span>An ID of 0 means an Assessment Criteria has not yet been assigned to a course.</span>
            </div>
            <div class="table-responsive">
                <table class="table">
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
    </section>
    <section class="row mb-5">
        <div class="col-md-9 col-lg-8 mx-auto">
            <h2>Assessment Criteria</h2>
            <div class="alert alert-info d-flex align-items-center" role="alert">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-info-circle-fill flex-shrink-0 me-2" viewBox="0 0 16 16">
                    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                </svg>
                <span>The same assessment criteria can be assigned to multiple courses.</span>
            </div>
            <div class="mb-3">
                <a href="newAssessmentCriteriaForm.jsp" class="btn btn-primary">Create Assessment Criteria</a>
            </div>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col" class="align-top">Course ID</th>
                        <th scope="col" class="align-top">Assessment Criteria ID</th>
                        <th scope="col" colspan="5" class="align-top">Quizzes</th>
                        <th scope="col" colspan="3" class="align-top">Assignments</th>
                        <th scope="col" class="align-top">Midterm Exam</th>
                        <th scope="col" class="align-top">Final Exam</th>
                        <th scope="col" class="align-top">Total</th>
                        <th scope="col" class="align-top">Edit</th>
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
                                            "<td>" + singleCriteria.getMidterm() + "%</td>\n" +
                                            "<td>" + singleCriteria.getFinalExam() + "%</td>\n" +
                                            "<td>100%</td>" +
                                            "<td>\n" +
                                            "<form action=\"PopulateAssessmentCriteriaForm\" method=\"post\">" +
                                            "<input type=\"hidden\" name=\"id\" value=\"" + singleCriteria.getId() + "\"/>" +
                                            "<button class=\"btn btn-sm btn-primary\" type=\"submit\">Edit</button>\n" +
                                            "</form>" +
                                            "</td>\n" +
                                            "</tr>");
                                }
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
    <section class="row mb-5">
        <div class="col-md-9 col-lg-8 mx-auto">
            <h2>Student Assessments</h2>
            <div class="alert alert-info d-flex align-items-center" role="alert">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-info-circle-fill flex-shrink-0 me-2" viewBox="0 0 16 16">
                    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                </svg>
                <span>Unused/unmarked assessments will show a 0.</span>
            </div>
            <div class="mb-3">
                <a href="newStudentAssessmentForm.jsp" class="btn btn-primary">Create Student Assessment</a>
            </div>
            <table class="table table-bordered table-responsive">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course ID</th>
                    <th scope="col" class="align-top">Student ID</th>
                    <th scope="col" colspan="5" class="align-top">Quizzes</th>
                    <th scope="col" colspan="3" class="align-top">Assignments</th>
                    <th scope="col" class="align-top">Midterm Exam</th>
                    <th scope="col" class="align-top">Final Exam</th>
                    <th scope="col" class="align-top">Total</th>
                    <th scope="col" class="align-top">Edit</th>
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
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <%
                    for (StudentAssessment singleAssessment : assessments) {
                        for (Course singleCourse : courses) {
                            if (singleAssessment.getCourseId() == singleCourse.getId() && singleCourse.getInstructorId() == user.getId()) {
                                int total = singleAssessment.getQuiz1() + singleAssessment.getQuiz2() + singleAssessment.getQuiz3()
                                        + singleAssessment.getQuiz4() + singleAssessment.getQuiz5()
                                        + singleAssessment.getAssignment1() + singleAssessment.getAssignment2() + singleAssessment.getAssignment3()
                                        + singleAssessment.getMidterm() + singleAssessment.getFinalExam();
                                out.print("<tr>\n" +
                                        "<th scope=\"row\">" + singleAssessment.getCourseId() + "</th>\n" +
                                        "<td>" + singleAssessment.getStudentId() + "</td>\n" +
                                        "<td>" + singleAssessment.getQuiz1() + "</td>\n" +
                                        "<td>" + singleAssessment.getQuiz2() + "</td>\n" +
                                        "<td>" + singleAssessment.getQuiz3() + "</td>\n" +
                                        "<td>" + singleAssessment.getQuiz4() + "</td>\n" +
                                        "<td>" + singleAssessment.getQuiz5() + "</td>\n" +
                                        "<td>" + singleAssessment.getAssignment1() + "</td>\n" +
                                        "<td>" + singleAssessment.getAssignment2() + "</td>\n" +
                                        "<td>" + singleAssessment.getAssignment3() + "</td>\n" +
                                        "<td>" + singleAssessment.getMidterm() + "</td>\n" +
                                        "<td>" + singleAssessment.getFinalExam() + "</td>\n" +
                                        "<td>" + total + "</td>" +
                                        "<td>\n" +
                                        "<form action=\"PopulateStudentAssessmentForm\" method=\"post\">" +
                                        "<input type=\"hidden\" name=\"id\" value=\"" + singleAssessment.getId() + "\"/>" +
                                        "<button class=\"btn btn-sm btn-primary\" type=\"submit\">Edit</button>\n" +
                                        "</form>" +
                                        "</td>\n" +
                                        "</tr>");
                            }
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </section>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
