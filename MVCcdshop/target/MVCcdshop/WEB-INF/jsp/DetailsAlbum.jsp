<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detaily o albu</title>
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
        <h2>Detaily</h2>
        <fieldset style="width:300px">
            <c:out value="Žánr: ${detailsAlbum.genreid.name}" /><br /><br />
            <c:out value="Umělec: ${detailsAlbum.artistid.name}" /><br /><br />
            <c:out value="Název: ${detailsAlbum.title}" /><br /><br />
            <c:out value="Cena: ${detailsAlbum.price}" /><br /><br />
            <c:out value="Album Art: ${detailsAlbum.albumarturl}" /><br /><br />
        </fieldset>    
            <a href="EditAlbum?editAlbumId=${detailsAlbumId}">Upravit</a>
            <a href="/MVCcdshop/StoreManager/" id="current">Zpět</a>
    </body>
</html>
