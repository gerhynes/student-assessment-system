<html>
<head>
    <title>Student Dashboard</title>
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
            <h2>Your Registered Courses</h2>
            <table class="table table-responsive">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course Code</th>
                    <th scope="col" class="align-top">Course Name</th>
                    <th scope="col" class="align-top">Semester</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">CS50</th>
                    <td>Introduction to Programming</td>
                    <td>1</td>
                </tr>
                <tr>
                    <th scope="row">CS75</th>
                    <td>Databases</td>
                    <td>1</td>
                </tr>
                <tr>
                    <th scope="row">CS61</th>
                    <td>Computer Architecture</td>
                    <td>1</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mx-auto">
            <h2>Your Current Grades</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col" class="align-top">Course Code</th>
                    <th scope="col" class="align-top">Quizzes 10%</th>
                    <th scope="col" class="align-top">Assignments 10%</th>
                    <th scope="col" class="align-top">Midterm Exam 30%</th>
                    <th scope="col" class="align-top">Final Exam 50%</th>
                    <th scope="col" class="align-top">Total</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">CS50</th>
                    <td>9</td>
                    <td>9</td>
                    <td>28</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <th scope="row">CS75</th>
                    <td>8</td>
                    <td>7</td>
                    <td>25</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <th scope="row">CS61</th>
                    <td>9</td>
                    <td>8</td>
                    <td>27</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>