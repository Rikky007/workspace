<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cz.MVCcdshop.*"%>
<%@page import="java.util.List"%>

<jsp:useBean id="usersModel" class="cz.MVCcdshop.Models.UsersModel" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrace</title>
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
        <div id="login-error">${error}</div>
        <form method="POST" action="addUser.html" id="addUserForm">
            <fieldset>
                <legend>Uživatelské údaje</legend>
                <label for="username">Uživatelské jméno: </label><br />
                <input type="text" name="txtUsername" id="usersname"><br /><br />
                
                <label for="username">Heslo: </label><br />
                <input type="text" name="txtUsername" id="usersname"><br /><br />
                
                <label for="username">Heslo znovu: </label><br />
                <input type="text" name="txtUsername" id="usersname"><br /><br />
            </fieldset>
            <fieldset>
                <legend>Poštovní údaje</legend>
                
                <label for="firstname">Jméno: </label><br />
                <input type="text" name="txtFirstname" id="firstname"><br /><br />
                
                <label for="lastname">Příjmení: </label><br />
                <input type="text" name="txtLastname" id="lastname"><br /><br />
                
                <label for="address">Ulice a č.p.: </label><br />
                <input type="text" name="txtAddress" id="address"><br /><br />
                
                <label for="city">Město: </label><br />
                <input type="text" name="txtCity" id="city"><br /><br />
                
                <label for="postalCode">Směrovací číslo: </label><br />
                <input type="text" name="txtPostalCode" id="postalCode"><br /><br />
                
                <label for="country">Země: </label><br />
                <input type="text" name="txtCountry" id="country"><br /><br />
                
                <label for="phone">Telefon: </label><br />
                <input type="text" name="txtphone" id="phone"><br /><br />
                
                <label for="email">E-mail: </label><br />
                <input type="text" name="txtEmail" id="email"><br /><br />
            </fieldset>   
            
            <input type="submit" id="submit" value="Create">
        </form>
        <h1>Hello World!</h1>
    </body>
</html>
