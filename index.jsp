<%-- 
    Document   : index
    Created on : Jan 15, 2023, 12:12:32 PM
    Author     : patce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h5>User Email Verification</h5>
        <form action="UserVerification" method='post'>
            <label>Enter username: </label>
            <input type='text'name='username'/>
            <br/>
            <label>Enter email: </label>
            <input type="email" name='userEmail'/>
            <br/>
            <input type='submit' value='Enter'/>
        </form>
    </body>
</html>
