<%-- 
    Document   : verify
    Created on : Jan 15, 2023, 2:03:55 PM
    Author     : patce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verification Page</title>
    </head>
    <body>
        Enter code below: <br/>
        <form action='VerifyCode' method='post'>
            <input type="number" name='authcode' required="true"/>
            <input type="submit" value="Enter"/>
        </form>
    </body>
</html>
