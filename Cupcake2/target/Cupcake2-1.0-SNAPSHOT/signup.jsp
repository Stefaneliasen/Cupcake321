<%-- 
    Document   : signup
    Created on : 04-04-2017, 10:56:57
    Author     : Arne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="mystyle.css" rel="stylesheet" type="text/css"/>
    <img src="cupcake.jpg" alt=""/>
</head>

<div id="background">
    <form action="RegisterServlet" method="post" id="center">
        <h2>Sign up</h2>
        <div>
            <label for="Username">Enter new username:</label>
            <br>
            <input type="text" id="Username" name="registerUsername" placeholder="Username">
            <br>
        </div>
        <div>
            <label for="Password">Enter new password:</label>
            <br>
            <input type="password" id="Password" name="registerPassword" placeholder="Password">
            <br>
        </div>
        <div>
            <label for="userId">Enter valid userId:</label>
            <br>
            <input type="text" id="userId" name="registeruserId" placeholder="1">
            <br>
        </div>
        <div>
            <label for="balance">Enter your balance:</label>
            <br>
            <input type="text" id="balance" name="balance" placeholder="30">
            <br>
        </div>

        <div>
            <label for="Email">Enter email address:</label>
            <br>
            <input type="email" id="Email" name="registerEmail" placeholder="dummy@gmail.com">
            <br>
        </div>
        <br>
        <!--<input type="hidden" name="action" value="Sign up">-->
        <input type="hidden" name="action" value="register">
        <input type="submit" value="Sign up">
        <br>
    </form>
</div>
<body>
</body>
</html>
