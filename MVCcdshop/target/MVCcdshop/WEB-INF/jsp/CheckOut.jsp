<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Odbavení objednávky</title>
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
        <h2>Děkujeme za nákup</h2>
        <h3>Číslo vaší objednávky je: ${myCartId}</h3>
    </body>
</html>
