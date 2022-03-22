<%--
  Created by IntelliJ IDEA.
  User: Gerard
  Date: 21/03/2022
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Course Form</title>
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
            <h2>Create/Edit Course</h2>
            <c:if test="${course != null}">
            <h2>Edit Course</h2>
            <form action="UpdateCourse" method="post">
                </c:if>
                <c:if test="${course == null}">
                    <h2>Create Course</h2>
                <form action="CreateCourse" method="post">
                    </c:if>
                    <c:if test="${course != null}">
                        <input type="hidden" name="id" value="<c:out value='${course.id}' />"/>
                    </c:if>
                    <div class="mb-3">
                        <label for="courseCode">Course Code</label>
                        <input class="form-control" name="courseCode" type="text"
                               value="<c:out value='${course.courseCode}'/>" id="courseCode" required="required"/>
                    </div>
                    <div class="mb-3">
                        <label for="name">Course Name</label>
                        <input class="form-control" name="name" type="text"
                               value="<c:out value='${course.name}'/>" id="name" required="required"/>
                    </div>
                    <div class="mb-3">
                        <label for="instructorId">Instructor ID</label>
                        <input class="form-control" name="instructorId" type="text"
                               value="<c:out value='${course.instructorId}'/>" id="instructorId"/>
                    </div>
                    <div class="mb-3">
                        <label for="semester">Semester</label>
                        <input class="form-control" name="semester" type="text"
                               value="<c:out value='${course.semester}'/>" id="semester" required="required"/>
                    </div>
                    <div class="mb-3">
                        <label for="assessmentId">Assessment ID</label>
                        <input class="form-control" name="assessmentId" type="text"
                               value="<c:out value='${course.assessmentId}'/>" id="assessmentId"/>
                    </div>
                    <div class="mb-3 d-grid">
                        <button class="btn btn-primary">
                            Save
                        </button>
                    </div>
                </form>
        </div>
    </div>
</div>
</body>
</html>
