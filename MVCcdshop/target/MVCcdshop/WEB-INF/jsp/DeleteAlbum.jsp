<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smazání alba</title>
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
        <h2>Smazání</h2>
        <br />
        <h2>Určitě chcete smazat toto album?</h2>
        <form:form modelAttribute="deleteAlbum" method="POST" commandName="deleteAlbum" action="/MVCcdshop/ShopManager/DeleteAlbum?deleteAlbumId=${deleteAlbum.albumid}" >
            <fieldset style="width:300px">
                <legend>Album</legend>    
                <c:out value="Žánr: ${deleteAlbum.genreid.name}"/><br /><br />
                <c:out value="Umělec: ${deleteAlbum.artistid.name}"/><br /><br />
                <c:out value="Název: ${deleteAlbum.title}"/><br /><br />
                <c:out value="Cena: ${deleteAlbum.price}"/><br /><br />
                <c:out value="Album art: ${deleteAlbum.albumarturl}"/><br /><br />

            </fieldset>
            <input type="submit" value="Smazat" /><a href="/MVCcdshop/ShopManager/" id="current">Zpět</a>   
        </form:form>    

    </body>
</html>
