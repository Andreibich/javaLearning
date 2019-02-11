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
<a href="/stock/userMenu" class="btn btn-primary" role="button">Return to menu</a>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Purpose</th>
        <th scope="col">Product</th>
        <th scope="col">Unit</th>
        <th scope="col">Quantity</th>
        <th scope="col">Price</th>
        <th scope="col">Date</th>
        <th scope="col">Stockman surname</th>
        <th scope="col">Recepient Company</th>
        <th scope="col">Invoice number</th>
        <th scope="col">Proxy number</th>
        <th scope="col">Recepient Name</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${shipmentList}" var="element">
        <tr>
            <td>
                <p>${element.shipmentId}</p>
            </td>
            <td>
                <p>${element.operationCodePurpose}</p>
            </td>
            <td>
                <p>${element.productCatalogName}</p>
            </td>
            <td>
                <p>${element.productCatalogUnit}</p>
            </td>
            <td>
                <p>${element.shipmentQuantity}</p>
            </td>
            <td>
                <p>${element.shipmentPrice}</p>
            </td>
            <td>
                <p>${element.shipmentDate}</p>
            </td>

            <td>
                <p>${element.shipmentUserSurname}</p>
            </td>
            <td>
                <p>${element.recepientCompanyName}</p>
            </td>

            <td>
                <p>${element.invoiceNumber}</p>
            </td>
            <td>
                <p>${element.proxyNumber}</p>
            </td>

            <td>
                <p>${element.recepientEmployeeName}</p>
            </td>


                <%--<td>--%>
                <%--<form action="FrontController" method="post" onsubmit="return confirm('Are you sure you want to delete this note?');">--%>
                <%--<input type="hidden" name="userId" value="${element.productId}">--%>
                <%--<input type="hidden" name="command" value="user_delete">--%>
                <%--<input class="btn btn-danger" type="submit" value="Delete">--%>
                <%--</form>--%>
                <%--</td>--%>
                <%--<td>--%>
                <%--<form action="FrontController" method="post">--%>
                <%--<input type="hidden" name="userId" value="${element.userId}">--%>
                <%--<input type="hidden" name="command" value="user_get_id">--%>
                <%--<input class="btn btn-danger" type="submit" value="Edit">--%>
                <%--</form>--%>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/stock/userMenu" class="btn btn-primary" role="button">Return to menu</a>

</body>

<script src="js/bootstrap.min.js" type="text/javascript"></script>

</html>
