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
        .button1 {
            position: relative;
            margin: 0 auto;
        }
    </style>
</head>
<body>

<div align="center">
    <div class="card card-body">
        <h3> Update user information </h3>
        <div class="row">

            <form action="FrontController" id="form-page-updating">
                <input type="hidden" name="command" value="user_edit">
                <div class="form-group">
                    <input type="hidden" name="userId" value="${userId}">
                    <%--<label for="Name">qwerty</label>--%>
                    <input type="text" class="form-control" id="Name" name="name" size="20" maxlength="25"
                           placeholder="Name" value="${name}" pattern="[а-яА-ЯёЁa-zA-Z]{2,25}" title="Only letters"
                           required>
                </div>
                <div class="form-group">
                    <%--<label for="Surname">Surname</label>--%>
                    <input type="text" class="form-control" id="Surname" name="surname" size="20" maxlength="25"
                           placeholder="Surname" value="${surname}" pattern="[а-яА-ЯёЁa-zA-Z]{2,25}"
                           title="Only letters" required>
                </div>
                <div class="form-group">
                    <%--<label for="Login">Login</label>--%>
                    <input type="text" class="form-control" id="Login" name="login" size="20" maxlength="25"
                           placeholder="Login" value="${login}" pattern="[а-яА-ЯёЁa-zA-Z]{2,25}" title="Only letters"
                           required>
                </div>
                <div class="form-group">
                    <%--<label for="Password">Password</label>--%>
                    <input type="password" class="form-control" id="Password" name="password" size="20" maxlength="25"
                           placeholder="Password" value="${password}" pattern="((?=.*[0-9a-zA-Zа-яА-ЯёЁ@#$%]).{6,20})"
                           title="Min - 6 symbols, max - 20 symbols" required>
                </div>
                <div class="form-group">
                    <%--<label for="PhoneNumber">PhoneNumber</label>--%>
                    <input type="text" class="form-control" id="Phone_Number" name="phone_number" size="20" maxlength="25"
                           placeholder="Phone Number " value="${phoneNumber}" pattern="(\+([0-9]{12}))"
                           title="+XXXXXXXXXXXX" required>
                </div>
                <div class="form-group">
                    <%--<label for="Email">Email</label>--%>
                    <input type="text" class="form-control" id="Email" name="email" size="20" maxlength="25"
                           placeholder="Email" value="${email}"
                           pattern="([A-z0-9_.-]{1,})@([A-z0-9_.-]{1,}).([A-z]{2,8})" title="Example: xxxxxx@gmail.com"
                           required>
                </div>
                <div class="form-group">
                    <%--<label for="CreationDate">Edit Date</label>--%>
                    <input type="date" class="form-control" id="Creation_Date" name="creation_date" size="20"
                           maxlength="25"
                           placeholder="Creation Date" value="${creationDate}" required>
                </div>
                <div class="form-group">
                    <select class="form-control" type="text" id="Type" name="type"
                            value="${type}">
                        <option>user</option>
                        <option>admin</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" id="finish_button" value="Update">
                </div>
            </form>
            <form action="FrontController" id="form-page-registration1" class="button1">
                <input type="hidden" name="command" value="test_command">
                <input type="submit" id="cancel_button" value="Cancel">
            </form>
        </div>
    </div>
    <%--</div>--%>
</div>
<script src="js/bootstrap.min.js"></script>
</body>

