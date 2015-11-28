<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head></head>
    <body>
        <% if (session.getAttribute("error")!=null) { out.print(session.getAttribute("error")); } %>
        <form method="post" action="login">
            User: <input class="form-control" name="username" type="text" maxlength="255" /><br/>
            Password: <input class="form-control" name="password" type="password" maxlength="255" /><br/>
            <button class="btn btn-default" type="submit" id="login">Log in</button>
        </form>
    </body>
</html>