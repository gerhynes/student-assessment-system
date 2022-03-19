<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
            <h2>Available Courses</h2>
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course Code</th>
                    <th scope="col" class="align-top">Course Name</th>
                    <th scope="col" class="align-top">Semester</th>
                    <th scope="col" class="align-top">Registered Students</th>
                    <th scope="col" class="align-top">Instructor</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">CS50</th>
                    <td>Introduction to Programming</td>
                    <td>1</td>
                    <td>150</td>
                    <td>
                        <button class="btn btn-sm btn-primary">Assign Instructor</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">CS75</th>
                    <td>Databases</td>
                    <td>1</td>
                    <td>120</td>
                    <td>
                        <button class="btn btn-sm btn-primary">Assign Instructor</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">CS61</th>
                    <td>Computer Architecture</td>
                    <td>1</td>
                    <td>110</td>
                    <td>
                        <button class="btn btn-sm btn-primary">Assign Instructor</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mx-auto">
            <form class="form p-4" action="getCourse">
                <div class="mb-3">
                    <label for="courseId">Course</label>
                    <input class="form-control" type="text" name="courseId" id="courseId" aria-describedby="courseHelp"/>
                    <div id="courseHelp" class="form-text">Search by course id</div>
                </div>
                <button type="submit" class="btn btn-primary">Get Course</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>