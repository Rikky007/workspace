<%--
JSP stranka slozici pro zobrazeni seznamu alb.

pokud neexistujou zadne kategorie zobrazime info hlasku jinak vytvorime tabulku
--%>
<c:choose>
    <c:when test="${empty albums}"><i><fmt:message key="album.no.result" /></i></c:when>
    <c:otherwise>
        <a href="<c:url value="/show-cart.htm"/>">Kosik</a>
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="album.label.title" /></th>
                    <th><fmt:message key="album.label.artist" /></th>
                    <th><fmt:message key="album.label.price" /></th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <%--
               foreachem projdeme vsechny existujici kategorie a pro kazdou udelam jeden radek
                --%>
                <c:forEach items="${albums}" var="item">
                    <tr>
                        <td><c:out value="${item.title}"/></td>
                        <td><c:out value="${item.artist}"/></td>
                        <td><c:out value="${item.price}"/></td>
                        <%--
                        priklad pouziti knihovny jstl-fn a to substring pro zobrazeni jen prvnich 60 znaku popisu                             
                        --%>
                        <td>
                            <a href="<c:url value="/album-edit.htm?id=${item.albumid}"/>">
                                <img src="<c:url value="/images/icon-edit.png"/>" alt="<fmt:message key="button.edit" />" title="<fmt:message key="button.edit" />"/>
                            </a>
                        </td>
                        <td>
                            <a href="<c:url value="/album-delete.htm?id=${item.albumid}"/>" class="delete">
                                <img src="<c:url value="/images/icon-delete.png"/>" alt="<fmt:message key="button.delete" />" title="<fmt:message key="button.delete" />"/>
                            </a>
                        </td>
                        <td>
                            <a href="<c:url value="/add-to-cart.htm?id=${item.albumid}"/>" >
                                <img src="<c:url value="/images/icon-basket.png"/>" alt="<fmt:message key="button.basket" />" title="<fmt:message key="button.basket" />"/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<script type="text/javascript">
    $(document).ready(function () {
        $('a.delete').click(function () {
            return confirm('<fmt:message key="delete.confirmation" />');
        });
    });
</script>
