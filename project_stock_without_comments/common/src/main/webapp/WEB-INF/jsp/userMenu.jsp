<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%--<script src="js/bootstrap.min.js"></script>--%>
    <style>
        ul {
            width: 150px;
            list-style: none;
            margin: 0;
            padding: 0;
        }
        li {
            position: relative;
        }
        li ul {
            display: none;
            position: absolute;
            top: 0;
            left: 151px;
        }
        li a {
            display: block;
            background-color: grey;
            color: white;
            text-decoration: none;
            border: 1px solid black;
            border-radius: 5px;
            padding: 5px;
            margin-bottom: 1px;
        }
        li a:hover {
            background-color: #0066ff;
        }
        li:hover ul {
            display: block;
        }
        @media all and (min-width: 915px) {
            ul {
                width: 915px;
            }
            li {
                margin-left: -3px;
                width: 150px;
                display: inline-block
            }
            li ul {
                top: 37px;
                left: 3px;
            }
            li ul li {
                display: block;
            }
        }
        body {
            background-image: url(images/otapl-skaldy.jpg);
            background-size: 100%;
        }
    </style>
</head>
<BODY>
<ul>
    <li><a href="">Product catalog</a>
        <ul>
            <li><a href="FrontController?command=product_list">View products</a></li>
            <li><a href="#">Create new product</a></li>
        </ul>
    </li>
    <li><a href="">Operation codes</a>
        <ul>
            <li><a href="FrontController?command=codes_list">View codes</a></li>
            <li><a href="#">Create new code</a></li>
        </ul>
    </li>
    <li><a href="">Companies</a>
        <ul>
            <li><a href="FrontController?command=companies_list">View companies</a></li>
            <li><a href="#">Create new company</a></li>
        </ul>
    </li>
    <li><a href="">Receipt</a>
        <ul>
            <li><a href="FrontController?command=receipt_list">View all receipts</a></li>
            <li><a href="#">Create new receipt</a></li>
            <li><a href="#">Find receipt by period</a></li>
            <li><a href="#">Find receipt by period and product</a></li>
            <li><a href="#">Find receipt by period and company</a></li>
        </ul>
    </li>
    <li><a href="">Shipment</a>
        <ul>
            <li><a href="FrontController?command=shipment_list">View all shipments</a></li>
            <li><a href="#">Create new shipment</a></li>
            <li><a href="#">Find shipment by period</a></li>
            <li><a href="#">Find shipment by period and product</a></li>
            <li><a href="#">Find shipment by period and company</a></li>
        </ul>
    </li>
    <li><a href="">Stock</a>
        <ul>
            <li><a href="FrontController?command=stock_view">View all products in stock by now</a></li>
            <li><a href="#">View all products in stock by date</a></li>
        </ul>
    </li>
</ul>
</BODY>
<script src="js/bootstrap.min.js"></script>
</html>

