<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Users</title>
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
                <h3 class="text-center mb-4">Delete a user</h3>
                <hr />
                <div class="alert alert-danger">
                    Are you to delete this user ?
                </div>
                <form:form method="post"  modelAttribute="newUser" action="/admin/user/delete">
                     <div class="mb-3" style="display: none;">
                        <label class="form-label">ID: </label>
                        <form:input value="${id}" type="text" cssClass="form-control" path="id"/>
                    </div>
                    <button class="btn btn-danger">Confirm</button>
                    <a  type="submit" class="btn btn-warning">Back</a>
                </form:form>
            </div>
        </div>    
    </div>
</body>   