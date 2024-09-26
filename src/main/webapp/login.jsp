<%--
  Created by IntelliJ IDEA.
  User: meisam
  Date: 9/26/2024
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <input type="text" name="user" placeholder="username"/>
    <br/>
    <input type="password" name="pass" placeholder="password"/>
    <br/>
    <button type="submit">Login</button>
</form>
<br/>
<%
    if(session.getAttribute("error")!=null) {
        out.print(session.getAttribute("error"));
    }
%>
</body>
</html>
