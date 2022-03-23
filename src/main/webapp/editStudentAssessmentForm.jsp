<%@ page import="com.example.models.User" %>
<%@ page import="com.example.models.StudentAssessment" %>
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
    StudentAssessment assessment = (StudentAssessment) session.getAttribute("currentAssessment");
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
            <h2>Edit Student Assessment</h2>
            <div class="alert alert-info d-flex align-items-center" role="alert">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-info-circle-fill flex-shrink-0 me-2" viewBox="0 0 16 16">
                    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                </svg>
                <span>Enter 0 for unused/not yet marked assessments.</span>
            </div>
            <form action="UpdateStudentAssessment" method="post">
                <input type="hidden" name="id" value="<%= assessment.getId() %>"/>
                <div class="mb-3">
                    <label for="studentId">Student ID</label>
                    <input class="form-control" name="studentId" type="text"
                           value="<%= assessment.getStudentId() %>" id="studentId" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="courseId">Course ID</label>
                    <input class="form-control" name="courseId" type="text"
                           value="<%= assessment.getCourseId() %>" id="courseId" required="required"/>
                </div>
                <h3 class="fs-5">Quizzes (Up to 5. Can total between 10% and 20%. Set as 0 if not used)</h3>
                <div class="mb-3">
                    <label for="quiz1">Quiz1</label>
                    <input class="form-control" name="quiz1" type="text"
                           value="<%= assessment.getQuiz1() %>" id="quiz1" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz2">Quiz2</label>
                    <input class="form-control" name="quiz2" type="text"
                           value="<%= assessment.getQuiz2() %>" id="quiz2" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz3">Quiz3</label>
                    <input class="form-control" name="quiz3" type="text"
                           value="<%= assessment.getQuiz3() %>" id="quiz3" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz4">Quiz4</label>
                    <input class="form-control" name="quiz4" type="text"
                           value="<%= assessment.getQuiz4() %>" id="quiz4" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz5">Quiz5</label>
                    <input class="form-control" name="quiz5" type="text"
                           value="<%= assessment.getQuiz5() %>" id="quiz5" required="required"/>
                </div>
                <h3 class="fs-5">Assignments (Up to 3. Can total between 10% and 20%. Set as 0 if not used)</h3>
                <div class="mb-3">
                    <label for="assignment1">Assignment1</label>
                    <input class="form-control" name="assignment1" type="text"
                           value="<%= assessment.getAssignment1() %>" id="assignment1" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="assignment2">Assignment2</label>
                    <input class="form-control" name="assignment2" type="text"
                           value="<%= assessment.getAssignment2() %>" id="assignment2" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="assignment3">Assignment3</label>
                    <input class="form-control" name="assignment3" type="text"
                           value="<%= assessment.getAssignment3() %>" id="assignment3" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="midterm">Midterm Exam - Worth 30% of overall grade</label>
                    <input class="form-control" name="midterm" type="text"
                           value="<%= assessment.getMidterm() %>" id="midterm" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="finalExam">Final Exam - Worth 50% of total grade</label>
                    <input class="form-control" name="finalExam" type="text"
                           value="<%= assessment.getFinalExam() %>" id="finalExam" required="required"/>
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
