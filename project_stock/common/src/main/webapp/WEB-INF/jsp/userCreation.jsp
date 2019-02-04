<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <meta charset="UTF-8">
    <title>Registration</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            background-image: url(images/otapl-skaldy.jpg);
            background-size: 100%;
        }

        .card {
            /*margin-top: 120px;*/
            background-color: #95999c;
            width: 450px;
        }

        .row {
            width: 200px;
        }
    </style>
</head>
<body>
<div align="center">
    <%--<div class="container">--%>
        <div class="card card-body">
            <h3> New user regisrtation </h3>
            <div class="row">
                <form action="FrontController" id="form-page-registration">
                    <input type="hidden" name="command" value="registration">
                    <div class="form-group">
                        <%--<label for="Name">Name</label>--%>
                        <input type="text" class="form-control"  id="Name" name="name" size="20" maxlength="25" placeholder="Name">
                    </div>
                    <div class="form-group">
                        <%--<label for="Surname">Surname</label>--%>
                        <input type="text" class="form-control"  id="Surname" name="surname" size="20" maxlength="25" placeholder="Surname">
                    </div>
                    <div class="form-group">
                        <%--<label for="Login">Login</label>--%>
                        <input type="text" class="form-control" id="Login" name="login" size="20" maxlength="25" placeholder="Login">
                    </div>
                    <div class="form-group">
                        <%--<label for="Password">Password</label>--%>
                        <input type="password" class="form-control" id="Password" name="password" size="20" maxlength="25"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <%--<label for="PhoneNumber">PhoneNumber</label>--%>
                        <input type="text" class="form-control" id="PhoneNumber" name="phoneNumber" size="20" maxlength="25"
                               placeholder="Phone Number ">
                    </div>
                    <div class="form-group">
                        <%--<label for="Email">Email</label>--%>
                        <input type="text" class="form-control" id="Email" name="email" size="20" maxlength="25" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <%--<label for="CreationDate">Creation Date</label>--%>
                        <input type="text" class="form-control" id="CreationDate" name="creationDate" size="20" maxlength="25"
                               placeholder="Creation Date">
                    </div>
                    <div class="form-group">
                        <%--<label for="Type">Type</label>--%>
                        <input type="text" class="form-control" id="Type" name="type" size="20" maxlength="25" placeholder="Type">
                    </div>
                    <div class="form-group">
                        <input type="submit" id="finish_button" value="Register">
                    </div>
                </form>
            </div>
        </div>
    <%--</div>--%>
</div>
<script src="js/bootstrap.min.js"></script>
</body>
