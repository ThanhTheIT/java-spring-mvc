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
    <title>Create Product</title>
    <link href="/css/styles.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <script>
      $(document).ready(() => {
        const imageFile = $("#imageFile");
        imageFile.change(function (e) {
          const imgURL = URL.createObjectURL(e.target.files[0]);
          $("#imagePreview").attr("src", imgURL);
          $("#imagePreview").css({ display: "block" });
        });
      });
    </script>
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
              <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
              <li class="breadcrumb-item">
                <a href="/admin/product">Product</a>
              </li>
              <li class="breadcrumb-item active">Create Product</li>
            </ol>

            <div class="container mt-5">
              <div class="row">
                <div class="col-md-8 col-12 mx-auto">
                  <h3 class="text-center mb-4">Create a product</h3>
                  <hr />

                  <form:form
                    method="post"
                    action="/admin/product/create"
                    modelAttribute="newProduct"
                    class="row"
                    enctype="multipart/form-data"
                  >
                    <!-- Name -->
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Name:</label>
                      <form:input path="name" cssClass="form-control" />
                    </div>

                    <!-- Price -->
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Price:</label>
                      <form:input
                        path="price"
                        cssClass="form-control"
                        type="number"
                        step="0.01"
                      />
                    </div>

                    <!-- Detail description -->
                    <div class="mb-3 col-12">
                      <label class="form-label">Detail description:</label>
                      <form:textarea
                        path="detailDesc"
                        cssClass="form-control"
                        rows="3"
                      />
                    </div>

                    <!-- Short description -->
                    <div class="mb-3 col-12">
                      <label class="form-label">Short description:</label>
                      <form:input path="shortDesc" cssClass="form-control" />
                    </div>

                    <!-- Quantity -->
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Quantity:</label>
                      <form:input
                        path="quantity"
                        cssClass="form-control"
                        type="number"
                      />
                    </div>

                    <!-- Factory -->
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Factory:</label>
                      <form:select class="form-select" path="factory">
                        <form:option value="APPLE">Apple (MacBook)</form:option>
                        <form:option value="ASUS">Asus</form:option>
                        <form:option value="LENOVO">Lenovo</form:option>
                        <form:option value="DELL">Dell</form:option>
                        <form:option value="LG">LG</form:option>
                        <form:option value="ACER">Acer</form:option>
                      </form:select>
                    </div>

                    <!-- Target -->
                    <div class="mb-3 col-12 col-md-6">
                      <label class="form-label">Target:</label>
                      <form:select class="form-select" path="target">
                        <form:option value="GAMING">Gaming</form:option>
                        <form:option value="SINHVIEN-VANPHONG"
                          >Sinh viên - Văn phòng</form:option
                        >
                        <form:option value="THIET-KE-DO-HOA"
                          >Thiết kế đồ họa</form:option
                        >
                        <form:option value="MONG-NHE">Mỏng nhẹ</form:option>
                        <form:option value="DOANH-NHAN">Doanh nhân</form:option>
                      </form:select>
                    </div>

                    <!-- Image -->
                    <div class="mb-3 col-12">
                      <label for="imageFile" class="form-label">Image:</label>
                      <input
                        type="file"
                        name="image"
                        class="form-control"
                        id="imageFile"
                        accept=".png, .jpg, .jpeg"
                      />
                    </div>

                    <div class="col-12 mb-3">
                      <img
                        style="max-height: 250px; display: none"
                        alt="image preview"
                        id="imagePreview"
                      />
                    </div>

                    <div class="col-12 mb-5">
                      <button type="submit" class="btn btn-primary">
                        Create
                      </button>
                    </div>
                  </form:form>
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
