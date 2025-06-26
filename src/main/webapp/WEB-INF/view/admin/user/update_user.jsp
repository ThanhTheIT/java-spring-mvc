<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Users</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 col-12 mx-auto">
                <h3 class="text-center mb-4">Update a user</h3>
                <hr />

                <form:form method="post" action="/admin/user/update_user" modelAttribute="newUser">
                   
                   <div class="mb-3" style="display: none;">
                        <label class="form-label">ID: </label>
                        <form:input type="text" cssClass="form-control" path="id"/>
                    </div>

                
                 <div class="mb-3">
                        <label class="form-label">Email:</label>
                        <form:input type="email" class="form-control" path="email" disabled="true" />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Phone number:</label>
                        <form:input type="text" class="form-control" path="phone"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Full Name: </label>
                        <form:input path="fullName" cssClass="form-control"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Address:</label>
                        <form:input path="address" cssClass="form-control"/>
                    </div>

                    <a href="/admin/user"  type="submit" class="btn btn-warning">Back</a>
                    <button type="submit" class="btn btn-warning">Update</button>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
