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
    <div class="row">
        <div class="col-md-6 mx-auto">
            <h1 class="text-center mb-4">Register for the Student Assessment System</h1>
            <form class="card p-4" action="/student-assessment-system/RegisterUser" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" id="name" aria-describedby="nameHelp">
                    <div id="nameHelp" class="form-text">Your name</div>
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Role</label>
                    <select class="form-select" name="role" id="role" aria-describedby="roleHelp">
                        <option selected>Select a Role</option>
                        <option value="admin">Admin</option>
                        <option value="instructor">Instructor</option>
                        <option value="student">Student</option>
                    </select>
                    <div id="roleHelp" class="form-text">Select your role</div>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" id="password" aria-describedby="passwordHelp">
                    <div id="passwordHelp" class="form-text">Make it long and unique.</div>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
