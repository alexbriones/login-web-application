<% if (session.getAttribute("user") == null) {response.sendRedirect("login"); return;}%>
<%@ page import="Domain.Model.User.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head></head>
    <body>
        <h1>
            Welcome <%= ((User)session.getAttribute("user")).getUserName() %> to your home
        </h1>
        <p><a href="pages/page_1">Page 1</a></p>
        <p><a href="pages/page_2">Page 2</a></p>
        <p><a href="pages/page_3">Page 3</a></p>
        <p><a href="logout">logout</a></p>
    </body>
</html>
