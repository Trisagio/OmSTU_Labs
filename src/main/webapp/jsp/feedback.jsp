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
                <a class="nav-link" href="${pageContext.request.contextPath}/jsp/about.jsp">About</a>
                <a class="nav-link" href="${pageContext.servletContext.contextPath}/jsp/contacts.jsp">Contacts</a>
                <a class="nav-link active" aria-current="page">Feedback</a>
            </nav>
        </div>
    </header>

    <main class="px-3">
        <div class="bg-white border rounded-3 p-4 m-lg-3 text-dark">
            <h1>Technical support</h1>
            <form action="post">
                <div class="mb-3">
                    <label class="form-label" for="title">Brief description of your problem</label>
                    <input type="text" required minlength="5" class="form-control" id="title" placeholder="Enter a question description">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="email">Leave your email and phone number, so we can communicate with you</label>
                    <input type="email" class="form-control mb-3" name="email" id="email" placeholder="Your e-mail"/>
                    <input type="tel" class="form-control" name="phone" id="phone" placeholder="+7">
                </div>
                <button type="submit" class="btn btn-dark">Send out</button>
            </form>
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
