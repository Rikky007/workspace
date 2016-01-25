<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<li><a href="/MVCcdshop/spring/Shop/">Shop</a></li>
	</ul>
</div>
<h1>Dostupné žánry:</h1>
<div style="height:20px"></div>
<ul>
	<li><a href="Browse?genre=Classical">Klasika</a></li>
	<li><a href="Browse?genre=Jazz">Jazz</a></li>
	<li><a href="Browse?genre=Rock">Rock</a></li>
</ul>
</body>
</html>