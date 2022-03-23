<html>
<head>
    <title>Student Assessment System</title>
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
    <div class="row">
        <div class="col-md-6 mx-auto">
            <h1 class="text-center mb-4">Sign In</h1>
            <div class="alert alert-info d-flex align-items-center" role="alert">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-info-circle-fill flex-shrink-0 me-2" viewBox="0 0 16 16">
                    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
                </svg>
                <span>Example Accounts</span>
            </div>
            <ul class="list-group mb-3">
                <li class="list-group-item">Admin: Brenda Lee password123</li>
                <li class="list-group-item">Instructor: Dr Amy Sedaris password123</li>
                <li class="list-group-item">Student: Wu Zeitan password123</li>
            </ul>
            <form class="card p-4" action="LoginUser" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" id="name" aria-describedby="nameHelp">
                    <div id="nameHelp" class="form-text">Use the same name you registered with</div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" id="password"
                           aria-describedby="passwordHelp">
                    <div id="passwordHelp" class="form-text">Use the same password you registered with</div>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Log In</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
