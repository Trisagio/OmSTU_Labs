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
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/jsp/about.jsp">About</a>
                <a class="nav-link active" aria-current="page">Contacts</a>
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/jsp/feedback.jsp">Feedback</a>
            </nav>
        </div>
    </header>

    <main class="lead">
        <h2>You may use the following contacts to communicate with us</h2>
        <h5>Telephone number: <a class="link-light" href="tel:+7 (908) 897-54-45">+7 (913) 650-34-21</a></h5>
        <h5>E-mail address: <a class="link-light" href="mailto:students@labs.com">evolvedynamics@evo.com</a></h5>
        <p><p></p>To leave or review a comment, please go to the discussion section</p>
        <button type="button" class="btn btn-lg btn-secondary px-4 fw-bold border-white text-white">Discuss</button>
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