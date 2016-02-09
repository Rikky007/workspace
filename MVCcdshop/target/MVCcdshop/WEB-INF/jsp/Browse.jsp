<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>        
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Store Browse</title>
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
    <h2>Dostupné žánry (${genreCount}):</h2>
        <c:forEach items="${foundAlbum}" var="myAlbum" >
            <c:url var="albumUrl" value="Details?albumId=${myAlbum.albumId}" />
            <h3 style="color:Red"><li><a href="${albumUrl}"><c:out value="${myAlbum.title}" /></a></li></h3>
        </c:forEach>    
</body>
</html>