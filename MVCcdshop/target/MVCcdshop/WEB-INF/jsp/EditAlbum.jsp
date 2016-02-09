<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editace alba</title>
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
        <h2>Editace</h2>
        
        <form:form modelAttribute="editAlbum" method="POST" commandName="editAlbum" action="MVCcdshop/ShopManager/EditAlbum?editAlbum=${editAlbum.albumid}">
            <fieldset style="width:300px">
            <h3>Žánr</h3>
            <select name="genreSelected">
                <c:forEach items="${genres}" var = "myGenre">
                    <option value="${myGenre.genreid}" ${myGenre.name==selectedGenre?'selected':''}>${myArtist.name}</option>
                </c:forEach>
            </select>
            <br />
            
            <h3>Umělec</h3>
            <select name="artistSelected">
                <c:forEach items="${artists}" var = "myArtist">
                    <option value="${myArtist.artistid}" ${myArtist.name==selectedArtist?'selected':''}>${myArtist.name}</option>
                </c:forEach>
            </select>
            <br />
            
            <h3>Název</h3>
            <form:input name ="txtTitle" path="title"/>
            <br />
            
            <h3>Cena</h3>
            <form:input path ="price"/>
            <br />
            
            <h3>AlbumArt</h3>
            <form:input path ="albumArt" />
            <br />
            
            <input type="submit" value="Uložit" />
            <br />
            <br />
            </fieldset>
        </form:form>
        
        <a href="/MVCcdshop/ShopManager" id="current">Zpět na seznam alb</a>
    </body>
</html>
