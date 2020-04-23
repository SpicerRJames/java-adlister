<%--
  Created by IntelliJ IDEA.
  User: jamesspicer
  Date: 4/22/20
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Product Show Page"/>
    </jsp:include>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../partials/header.jsp"/>
<div class="container">
    <!--Title of our product -->
    <h1>Current Product: ${product.title}</h1>
    <!--price of our product -->
    <p>Price $${product.priceInCents/100}</p>
    <!--description of our product -->
    <h3>Description</h3>
    <p>${product.description}</p>


</div>
</body>
</html>
