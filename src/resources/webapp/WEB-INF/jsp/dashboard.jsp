<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Dashboard</h1>
        <div class="row">
            <div class="col-md-4">
                <div class="card shadow">
                    <div class="card-body text-center">
                        <h5 class="card-title">Manage Events</h5>
                        <p class="card-text">Create, update, or delete events.</p>
                        <a href="events.jsp" class="btn btn-primary">Go</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card shadow">
                    <div class="card-body text-center">
                        <h5 class="card-title">View Resources</h5>
                        <p class="card-text">View and allocate resources for events.</p>
                        <a href="resources.jsp" class="btn btn-primary">Go</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card shadow">
                    <div class="card-body text-center">
                        <h5 class="card-title">Generate Reports</h5>
                        <p class="card-text">Download reports for your events.</p>
                        <a href="reports.jsp" class="btn btn-primary">Go</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>