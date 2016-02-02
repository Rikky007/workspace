<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@page import="cz.MVCcdshop.*"%>
<%@page import="cz.MVCcdshop.Entities.*" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>       
<%@page import="java.util.List"%>
<%@page import="java.util.Map" %>


<jsp:useBean id="albumModel" type="cz.MVCcdshop.Models.AlbumModel" scope="request" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store Manager</title>
        <link rel="stylesheet" media="screen" type="text/css" href="../Site.css"/>
    </head>
    <body>
        <div id="header">
            <h1>MVC CDshop</h1>
            <ul id="navlist">
                <li class="first"><a href="/MVCcdshop/" id="current">Home</a></li>
                <li><a href="/MVCcdshop/spring/Shop/">Shop</a></li>
            </ul>
        </div>
        <h2>Index</h2>
        <h3 style="color:Red"><a href="/MVCcdshop/ShopManager/CreateAlbum">Vytvoř nové</a></h3>
        <table>
            <thead>
                <tr>
                    <th>Žánr</th>
                    <th>Umělec</th>
                    <th>Název</th>
                    <th>Cena</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>    
            <tbody>
                <%for (Album myAlbum : albumModel.findAllAlbums()) {%>
                <tr>
                    <%int tempGenreId = myAlbum.getGenreid().getGenreid() %>
                    <%int tempArtistId = myAlbum.getArtistid().getArtistid() %>
                    <td><%=albumModel.findGenreByIdFromAlbumModel(tempGenreId).getName()%></td>
                    <td><%=albumModel.findArtistByIdFromAlbumModel(tempArtistId).getName()%></td>
                    <td><%=myAlbum.getTitle()%></td>
                    <td><%=myAlbum.getPrice()%></td>
                    <td><a href="EditAlbum?editAlbumId=<%=myAlbum.getAlbumid()%>">Upravit</a></td>
                    <td><a href="DetailsAlbum?editAlbumId=<%=myAlbum.getAlbumid()%>">Detaily</a></td>
                    <td><a href="DeleteAlbum?editAlbumId=<%=myAlbum.getAlbumid()%>">Smazat</a></td>

                </tr>
                <%}%>  
            </tbody>           
        </table>            
    </body>
</html>
