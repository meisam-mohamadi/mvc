<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login signup</title>
</head>
<body>
<a href="login.jsp">login</a>
<form action="signup" method="post">
    <input type="text" name="user" placeholder="username"/>
    <br/>
    <input type="password" name="pass" placeholder="password"/>
    <br/>
    <button type="submit">signUp</button>
</form>
<br/>
<%
    out.print(session.getAttribute("error"));
%>
</body>
</html>