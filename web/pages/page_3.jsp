<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="loginredirect.jsp" %>
<html>
    <head></head>
    <body>
        <h1>Hello <%= session.getAttribute("username") %>, you are in page 3</h1>
        <p><a href="../logout">logout</a></p>
    </body>
</html>
