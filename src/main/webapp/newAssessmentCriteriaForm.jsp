<%@ page import="com.example.web.models.User" %>
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
            <h2>Create Assessment Criteria</h2>
            <form action="CreateAssessmentCriteria" method="post">
                <div class="mb-3">
                    <label for="courseId">Course ID</label>
                    <input class="form-control" name="courseId" type="text" id="courseId" required="required"/>
                </div>
                <h3 class="fs-5">Quizzes (Up to 5. Can total between 10% and 20%. Set as 0 if not used)</h3>
                <div class="mb-3">
                    <label for="quiz1">Quiz1</label>
                    <input class="form-control" name="quiz1" type="number" id="quiz1" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz2">Quiz2</label>
                    <input class="form-control" name="quiz2" type="number" id="quiz2" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz3">Quiz3</label>
                    <input class="form-control" name="quiz3" type="number" id="quiz3" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz4">Quiz4</label>
                    <input class="form-control" name="quiz4" type="number" id="quiz4" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="quiz5">Quiz5</label>
                    <input class="form-control" name="quiz5" type="number" id="quiz5" required="required"/>
                </div>
                <h3 class="fs-5">Assignments (Up to 3. Can total between 10% and 20%. Set as 0 if not used)</h3>
                <div class="mb-3">
                    <label for="assignment1">Assignment1</label>
                    <input class="form-control" name="assignment1" type="number" id="assignment1" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="assignment2">Assignment2</label>
                    <input class="form-control" name="assignment2" type="number" id="assignment2" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="assignment3">Assignment3</label>
                    <input class="form-control" name="assignment3" type="number" id="assignment3" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="midterm">Midterm Exam Must be 30%</label>
                    <input class="form-control" name="midterm" type="number" id="midterm" required="required"/>
                </div>
                <div class="mb-3">
                    <label for="finalExam">Final Exam Must be 50%</label>
                    <input class="form-control" name="finalExam" type="number" id="finalExam" required="required"/>
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
