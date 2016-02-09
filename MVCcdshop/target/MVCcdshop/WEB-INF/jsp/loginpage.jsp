<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Přihlášení</title>
        <link rel="stylesheet" media="screen" type="text/css" href="../Site.css"/>
    </head>
    <body>
        <div id="header">
            <h1>MVC CDshop</h1>
            <ul id="navlist">
                <li class="first"><a href="/MVCcdshop/" id="current">Home</a></li>
                <li><a href="/MVCcdshop/Shop/">Shop</a></li>
            </ul>
        </div>
        <div id="Login-error">${error}</div>
        
        <form:form modelAttribute="login" method="POST" commandName="login" action="/MVCcdshop/Account/login">
            <h2>Přihlášení</h2>
            <h3>Zadejte uživatelské jméno a heslo</h3>
            <h3>Nebo se <a href="/MVCcdshop/addUser">registrujte</a></h3>
            <fieldset>
                <legend>Zadejte své údaje:</legend>
                
                <h3>Uživatelské jméno</h3>
                <form:input path="username" />
                <br /><br />
                
                <h3>Heslo</h3>
                <form:input path="password"/>
                <br /><br />
                
                <input type="submit" value="Log On" />
                <br />
            </fieldset>
        </form:form>
    </body>
</html>
