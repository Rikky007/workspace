<%-- 
    Document   : show-cart
    Created on : 12.2.2016, 20:05:08
    Author     : Grant
--%>

<c:choose>
    <c:when test="${empty cart-item}"><i><fmt:message key="cart.no.result" /></i></c:when>
    <c:otherwise>
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="album.label.title" /></th>
                    <th><fmt:message key="album.label.artist" /></th>
                    <th><fmt:message key="album.label.price" /></th>
                    <th>Pocet</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <%--
                foreachem projdeme vsechny existujici kategorie a pro kazdou udelam jeden radek
                --%>
                <c:forEach items="${cart-item}" var="item">
                    <tr>
                        <td><c:out value="${item.album.title}"/></td>
                        <td><c:out value="${item.album.artist}"/></td>
                        <td><c:out value="${item.album.price}"/></td>
                        <td><c:out value="${item.count}"/></td>
                        <td>
                            <a href="<c:url value="/remove-album.htm?id=${item.album.albumid}"/>" class="delete">
                                <img src="<c:url value="/images/icon-delete.png"/>" alt="<fmt:message key="button.delete" />" title="<fmt:message key="button.delete" />"/>
                            </a>
                        </td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
