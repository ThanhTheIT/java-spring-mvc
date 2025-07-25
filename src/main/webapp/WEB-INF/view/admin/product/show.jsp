<%@ page contentType="text/html" pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>LaptopShop</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <script
      src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp"></jsp:include>
    <div id="layoutSidenav">
      <jsp:include page="../layout/sidebar.jsp"></jsp:include>
      <div id="layoutSidenav_content">
        <main>
          <div class="container-fluid px-4">
            <h1 class="mt-4">Manage Product</h1>
            <ol class="breadcrumb mb-4">
              <li class="breadcrumb-item"><a href="/admin">Dashboard </a></li>
              <li class="breadcrumb-item active">Product</li>
            </ol>
            <div>
              <div class="row">
                <div class="col-12 mx-auto">
                  <div class="d-flex justify-content-between mb-3">
                    <h3>Table products</h3>
                    <a href="/admin/product/create" class="btn btn-primary"
                      >Create a product</a
                    >
                  </div>

                  <table class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Price</th>
                        <th>Factory</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="user" items="${users}">
                        <tr>
                          <td>${user.id}</td>
                          <td>${user.email}</td>
                          <td>${user.fullName}</td>
                          <td>${user.role.name}</td>
                          <td class="text-center">
                            <a
                              href="/admin/user/${user.id}"
                              class="btn btn-success"
                              >View</a
                            >
                            <a
                              href="/admin/user/update/${user.id}"
                              class="btn btn-warning"
                              >Update</a
                            >
                            <a
                              href="/admin/user/delete/${user.id}"
                              class="btn btn-danger"
                              >Delete</a
                            >
                          </td>
                        </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </main>
        <jsp:include page="../layout/footer.jsp"></jsp:include>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      crossorigin="anonymous"
    ></script>
    <script src="js/scripts.js"></script>
  </body>
</html>
