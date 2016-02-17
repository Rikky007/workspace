<%--
JSP stranka slozici pro zobrazeni seznamu objednávek.

pokud neexistujou zadne kategorie zobrazime info hlasku jinak vytvorime tabulku
--%>

//UPRAVUJE SE Z ALBUM_LIST


<c:choose>
    <c:when test="${empty cartitems}"><i><fmt:message key="order.no.result" /></i></c:when>
    <c:otherwise>
        
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="order.label.title" /></th>
                    <th><fmt:message key="order.label.price" /></th>
                    <th><fmt:message key="order.label.quantity" /></th>
                </tr>
            </thead>
            <tbody>
                <%--seznam položek objednávky--%>
                <c:forEach items="${cartitems}" var="item">
                    <tr>
                        <td><c:out value="${item.title}"/></td>
                        <td><c:out value="${item.artist}"/></td>
                        <td><c:out value="${item.price}"/></td>
                    </tr>
                </c:forEach>
                <tr><%--celková cena--%>
                    <td><fmt:message key="order.label.total" /></td>
                    <td colspan="2">
                        <c:forEach items="${cartitems}" var="item">
                            <c:set var="total" scope="session" value="${total+item.price}"/>
                        </c:forEach>
                    </td>
                </tr>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>