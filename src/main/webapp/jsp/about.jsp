<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Business card site example, date: 23.04.2023">
    <meta name="author" content="Lozhnikov Alexey">
    <title>EvolveDynamics · The future is already present!</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom style -->
    <link href="${pageContext.servletContext.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>

<body class="d-flex h-100 text-center text-white bg-dark">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="mb-auto">
        <div>
            <h3 class="float-md-start mb-0">EvolveDynamics</h3>
            <nav class="nav nav-masthead justify-content-center float-md-end">
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/jsp/main.jsp">Home</a>
                <a class="nav-link active" aria-current="page">About</a>
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/jsp/contacts.jsp">Contacts</a>
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/jsp/feedback.jsp">Feedback</a>
            </nav>
        </div>
    </header>

    <main class="px-4">
        <div class="row lead">
            <div class="col">
                <h2>Professionally</h2>
                <a>To carry out the work, we use the services of specialists in many areas, often poached from competitors.</a>
            </div>
            <div class="col">
                <h2>Possible</h2>
                <a>EvolveDynamics is committed to the implementation and development of innovative technologies.</a>
            </div>
            <div class="col">
                <h2>Inexpensive</h2>
                <a>Thanks to the unsurpassed skills of our slaves, competitors never dreamed of such prices!</a>
            </div>
        </div>
    </main>

    <footer class="mt-auto text-white-50">
        <p>
        <div class="text-white float-left">EvolveDynamics © 2023 </div>
        <a>All Rights Reserved</a>
        </p>
    </footer>
</div>
</body>
</html>
