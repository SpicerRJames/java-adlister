<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jamesspicer
  Date: 4/22/20
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="This is the ads page" />
    </jsp:include>

</head>
<body>

<c:forEach var="ad" items="${adsList}">
    <h3><c:out value="${ad.id}" /></h3>
    <p><c:out value="${ad.userId}" /></p>
    <h4><c:out value="${ad.title}" /></h4>
    <p><c:out value="${ad.description}" /></p>
</c:forEach>
</body>

</html>
