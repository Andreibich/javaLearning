<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html">

    <meta charset="UTF-8">
    <title>User list</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
        <th scope="col">Login</th>
        <th scope="col">Password</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Email</th>
        <th scope="col">Creation Date</th>
        <th scope="col">Type</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${testList}" var="element">
        <tr>
            <td>
                <p>${element.userId}</p>
            </td>
            <td>
                <p>${element.userName}</p>
            </td>
            <td>
                <p>${element.surname}</p>
            </td>
            <td>
                <p>${element.login}</p>
            </td>
            <td>
                <p>${element.password}</p>
            </td>
            <td>
                <p>${element.phoneNumber}</p>
            </td>
            <td>
                <p>${element.email}</p>
            </td>
            <td>
                <p>${element.creationDate}</p>
            </td>
            <td>
                <p>${element.type}</p>
            </td>
            <td>
                <form action="FrontController" method="post" onsubmit="return confirm('Are you sure you want to delete this note?');">
                    <input type="hidden" name="userId" value="${element.userId}">
                    <input type="hidden" name="command" value="user_delete">
                    <input class="btn btn-danger" type="submit" value="Delete">
                </form>
            </td>
            <td>
                <form action="FrontController" method="post">
                    <input type="hidden" name="userId" value="${element.userId}">
                    <input type="hidden" name="command" value="user_get_id">
                    <input class="btn btn-danger" type="submit" value="Edit">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/stock/admin" class="btn btn-primary" role="button">Return to menu</a>

</body>

<script src="js/bootstrap.min.js" type="text/javascript"></script>

</html>