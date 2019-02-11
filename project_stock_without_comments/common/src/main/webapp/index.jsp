<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Autorization</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            background-image: url(images/otapl-skaldy.jpg);
            background-size: 100%;
        }

        .card {
            margin-top: 120px;
            background-color: #95999c;
        }

        .row {
            width: 400px;
            margin-left: 400px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="card card-body">
            <h3> Autorization </h3>
            <form action="FrontController" id="autorization">
                <input type="hidden" name="command" value="autorization">
                <div class="form-group">
                    <label for="Login">Login</label>
                    <input type="text" class="form-control" id="Login" name="login" pattern="[а-яА-ЯёЁa-zA-Z]{2,25}"
                           aria-describedby="loginHelp" placeholder="Enter login"
                           title="Only letters" required>
                </div>
                <div class="form-group">
                    <label for="Password">Password</label>
                    <input type="password" class="form-control" id="Password" name="password"
                           pattern="(?=.*[0-9a-zA-Zа-яА-ЯёЁ@#$%]).{6,20}"
                           placeholder="Password" title="Min - 6 symbols, max - 20 symbols" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

