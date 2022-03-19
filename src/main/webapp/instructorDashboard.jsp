<%--
  Created by IntelliJ IDEA.
  User: Gerard
  Date: 19/03/2022
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Instructor Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-dark bg-dark mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="/student-assessment-system">Student Assessment</a>
    </div>
</nav>
<div class="container">
    <h1 class="text-center mt-5 mb-5">Student Assessment System</h1>
    <div class="row mb-5">
        <div class="col-md-6 mx-auto">
            <h2>Assigned Courses</h2>
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course Code</th>
                    <th scope="col" class="align-top">Course Name</th>
                    <th scope="col" class="align-top">Semester</th>
                    <th scope="col" class="align-top">Registered Students</th>
                    <th scope="col" class="align-top">Assessment</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">CS50</th>
                    <td>Introduction to Programming</td>
                    <td>1</td>
                    <td>150</td>
                    <td>
                        <button class="btn btn-sm btn-primary">Set Assessment</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">CS75</th>
                    <td>Databases</td>
                    <td>1</td>
                    <td>120</td>
                    <td>
                        <button class="btn btn-sm btn-primary">Set Assessment</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">CS61</th>
                    <td>Computer Architecture</td>
                    <td>1</td>
                    <td>110</td>
                    <td>
                        <button class="btn btn-sm btn-primary">Set Assessment</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mx-auto">
            <h2>Assessment Criteria</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course Code</th>
                    <th scope="col" class="align-top">Quizzes</th>
                    <th scope="col" class="align-top">Assignments</th>
                    <th scope="col" class="align-top">Midterm Exam</th>
                    <th scope="col" class="align-top">Final Exam</th>
                    <th scope="col" class="align-top">Total</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">CS50</th>
                    <td>10</td>
                    <td>10</td>
                    <td>30</td>
                    <td>50</td>
                    <td>100</td>
                </tr>
                <tr>
                    <th scope="row">CS75</th>
                    <td>10</td>
                    <td>10</td>
                    <td>30</td>
                    <td>50</td>
                    <td>100</td>
                </tr>
                <tr>
                    <th scope="row">CS61</th>
                    <td>10</td>
                    <td>10</td>
                    <td>30</td>
                    <td>50</td>
                    <td>100</td>
                </tr>
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
