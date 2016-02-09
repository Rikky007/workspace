<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store Details</title>
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
        <form:form modelAttribute="addedAlbum" method="POST" commandName="addedAlbum" action="/MVCcdshop/Shop/Details?albumId=${detailedAlbum.albumId}" >
            <h2><c:out value="${detailedAlbum.title}" /></h2>

            <img alt="album art alba : ${detailedAlbum.title}" src="../Images/placeholder.gif" /><br/>
            <div style="height:20px"></div>
            <h2><c:out value=" Žánr: ${detailedAlbum.genreid.name}" /></h2>
            <h2><c:out value=" Umělec: ${detailedAlbum.artistid.name}" /></h2>
            <h2><c:out value=" Cena: ${detailedAlbum.price}" /></h2>
            <input type="submit" value="do košíku" />
        </form:form>        
        </body>
    </html>