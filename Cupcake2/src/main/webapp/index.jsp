

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="mystyle.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <div id="center">
        <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <h3>Username:</h3> <input type="text" name="username" />
            <h3>Password:</h3> <input type="password" name="password" />
            <br>

            <input type="submit" value="Login" id="loginButton">
            <input type="hidden" name="action" value="login">
        </form>
        <br>
        <form action="signup.jsp" method="post">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Signup">
        </form>
    </form>
</div>
</html>