<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container text-center mt-5">
    <h1>Something went wrong</h1>
    <h2>Message <%=exception.getMessage()%></h2>
    <h2>Class <%=exception.getClass()%></h2>
    <h2>Stack Trace <%=exception.getStackTrace()%></h2>
</div>
</body>
</html>