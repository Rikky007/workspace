
    SAKRA
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
