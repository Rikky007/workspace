<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" media="screen" type="text/css" href="../Site.css"/>
<title>Shop index</title>
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

<c:forEach items="${genreList}" var="myGenre">
    <c:url var="albumUrl" value="Browse?genre=${myGenre.name}" />
           <h3><li><a href="${albumUrl}"><c:out value="${myGenre.name}"/></a></li></h3>      
           
</c:forEach>  


</body>
</html>