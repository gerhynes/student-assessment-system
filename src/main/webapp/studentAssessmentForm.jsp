<%@ page import="com.example.web.models.AssessmentCriteria" %>
<%@ page import="com.example.web.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Assessment System</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    AssessmentCriteria criteria = (AssessmentCriteria) session.getAttribute("currentCriteria");
%>
<nav class="navbar navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="/student-assessment-system">Student Assessment</a>
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
    <h1 class="text-center mt-5 mb-5">Student Assessment System</h1>
    <div class="row mb-5">
        <div class="col-md-6 mx-auto">
            <h2>Edit Student Assessment</h2>
            <form action="UpdateStudentAssessment" method="post">
                <input type="hidden" name="id" value="<%= criteria.getId() %>"/>
                <div class="mb-3">
                    <label for="courseId">Course ID</label>
                    <input class="form-control" name="courseId" type="text"
                           value="<%= criteria.getCourseId() %>" id="courseId" required="required"/>
                </div>
                <h3>Quizzes (Up to 5. Can total between 10% and 20%. Set as 0 if not used)</h3>
                <div class="mb-3">
                    <label for="quiz1">Quiz1</label>
                    <input class="form-control" name="quiz1" type="text"
                           value="<%= criteria.getQuiz1() %>" id="quiz1" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz2">Quiz2</label>
                    <input class="form-control" name="quiz2" type="text"
                           value="<%= criteria.getQuiz2() %>" id="quiz2" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz3">Quiz3</label>
                    <input class="form-control" name="quiz3" type="text"
                           value="<%= criteria.getQuiz3() %>" id="quiz3" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz4">Quiz4</label>
                    <input class="form-control" name="quiz4" type="text"
                           value="<%= criteria.getQuiz4() %>" id="quiz4" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz5">Quiz5</label>
                    <input class="form-control" name="quiz5" type="text"
                           value="<%= criteria.getQuiz5() %>" id="quiz5" required="required"/>
                </div>
                <h3>Assignments (Up to 3. Can total between 10% and 20%. Set as 0 if not used)</h3>
                <div class="mb-3">
                    <label for="assignment1">Assignment1</label>
                    <input class="form-control" name="assignment1" type="text"
                           value="<%= criteria.getAssignment1() %>" id="assignment1" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="assignment2">Assignment2</label>
                    <input class="form-control" name="assignment2" type="text"
                           value="<%= criteria.getAssignment2() %>" id="assignment2" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="assignment3">Assignment3</label>
                    <input class="form-control" name="assignment3" type="text"
                           value="<%= criteria.getAssignment3() %>" id="assignment3" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="midterm">Midterm Exam Must be 30%</label>
                    <input class="form-control" name="midterm" type="text"
                           value="<%= criteria.getMidterm() %>" id="midterm" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="finalExam">Final Exam Must be 50%</label>
                    <input class="form-control" name="finalExam" type="text"
                           value="<%= criteria.getFinalExam() %>" id="finalExam" required="required"/>
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
