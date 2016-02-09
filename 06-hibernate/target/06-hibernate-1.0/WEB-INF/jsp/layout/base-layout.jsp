<%--
Zakladni layout stranek, ktery vyuziva tiles framework k poskladani vysledne stranky.
--%>
<!DOCTYPE HTML>
<html lang="cs"> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <fmt:message>
                <jsp:attribute name="key" trim="true">
                    <tiles:getAsString name="title" ignore="true"/>
                </jsp:attribute>
            </fmt:message>
        </title>
        <link rel="shortcut icon" href="<c:url value="/images/categories.ico"/>">
        <link href="<c:url value="/style/main.css"/>" rel="stylesheet" type="text/css"/>
        <c:set var="jqueryUrl"><c:url value="/js/jquery-1.9.1.min.js"/></c:set>
        <script type="text/javascript" src="${jqueryUrl}"></script>
    </head>
    <body>
        <div id="header">
            <%--vlozeni tiles atributu z definice tilesu. Realne vlozi jsp stranku dle definice--%>
            <tiles:insertAttribute name="header" />
        </div>
        <div id="body">
            <div id="body-menu">
                <tiles:insertAttribute name="menu" />
            </div>
            <div id="body-content">
                <tiles:insertAttribute name="body" />
            </div>
            <div class="cleaner"></div> 
        </div>
        <div id="footer">
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>