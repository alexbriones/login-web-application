<%@ page import="Domain.Model.User.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/loginredirect.jsp" %>
<html>
    <head></head>
    <body>
        <h1>Hello <%= ((User)session.getAttribute("user")).getUserName() %>, you are in page 1</h1>
        <p><a href="/logout">logout</a></p>
    </body>
</html>
