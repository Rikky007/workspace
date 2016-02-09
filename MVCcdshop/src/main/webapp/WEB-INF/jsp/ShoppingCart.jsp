<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Košík</title>
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
        <form:form modelAttribute="myCart" method="POST" commandName="myCart" action="/MVCcdshop/ShoppingCart">
        <h3>Kontrola nákupu:</h3>
        <input type="submit" value="Checkout >" />
        <div style="height:20px"></div>
        <table>
            <thead>
                <tr>
                    <th>Název alba</th>
                    <th>Cena</th>
                    <th>Množství</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:out value="${removedAlbumInfo}" />
                <c:forEach items="${albumList}" var="myAlbum">
                    <tr>
                        <td><a href="/MVCcdshop/Shop/Details?albumId=${myAlbum.albumid}"><c:out value="${myAlbum.title}"/></a></td>
                        <td><c:out value="${myAlbum.price}"/></td>
                        <td><c:out value="1"/></td>
                        <td><a href="/MVCcdshop/ShoppingCart.html?deletedAlbumID=${myAlbum.albumid}"><c:out value="Odstranit z košíku"/></a></td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td>Celkem</td>
                        <td></td>
                        <td></td>
                        <td>${totalPrice}</td>
                    </tr>    
            </tbody>
        </table>
        </form:form>
    </body>
</html>
