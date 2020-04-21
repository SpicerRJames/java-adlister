<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jamesspicer
  Date: 4/21/20
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="./profile.jsp" method="post">
    <table>
        <tr><td>UserName :</td><td><input type="text" name="userName" id="username"></td></tr>
        <tr><td>Password :</td><td><input type="password" name="password"></td></tr>
<%--        <tr><td></td><td><input type="submit" value="SUBMIT"> <a href="/profile.jsp"></a> </td></tr>--%>
        <a href="${pageContext.request.contextPath}profile.jsp" >click</a>
    </table>
</form>

<c:choose>
    <c: when test="${name.param = "admin"}"
</c:choose>

<%--<%--%>
<%--    String userName = request.getParameter("userName");--%>
<%--    String password = request.getParameter("password");--%>

<%--    if(userName.equals("userName")){--%>
<%--        PrintWriter cool = response.getWriter();--%>
<%--        cool.println("Cool Name!");--%>
<%--    }--%>

<%--    if(password.equals("password")){--%>
<%--        PrintWriter cool = response.getWriter();--%>
<%--        cool.println("Succsses");--%>
<%--    } else if (password != "password"){--%>
<%--        PrintWriter fail = response.getWriter();--%>
<%--        fail.println("Password Failed");--%>
<%--    }--%>

<%--%>--%>

</body>
</html>
