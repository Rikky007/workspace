<%--
JSP stranka slozici pro zobrazeni seznamu kategorii.

pokud neexistujou zadne kategorie zobrazime info hlasku jinak vytvorime tabulku
--%>
<c:choose>
    <c:when test="${empty kategorie}"><i><fmt:message key="category.no.result" /></i></c:when>
    <c:otherwise>
        <table class="table">
            <thead>
                <tr>
                    <th><fmt:message key="category.label.name" /></th>
                    <th><fmt:message key="category.label.description" /></th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                 <%--
                foreachem projdeme vsechny existujici kategorie a pro kazdou udelam jeden radek
                --%>
                <c:forEach items="${kategorie}" var="item">
                    <tr>
                        <tr>
                        <td><c:out value="${item.nazev}"/></td>
                        <%--
                        priklad pouziti knihovny jstl-fn a to substring pro zobrazeni jen prvnich 60 znaku popisu                             
                        --%>
                        <td><c:out value="${fn:substring(item.popis, 0, 60)}"/></td>
                        <td>
                            <a href="<c:url value="/kategorie-upravit.htm?id=${item.idKategorie}"/>">
                                <img src="<c:url value="/images/icon-edit.png"/>" alt="<fmt:message key="button.edit" />" title="<fmt:message key="button.edit" />"/>
                            </a>
                        </td>
                        <td>
                            <a href="<c:url value="/kategorie-smazat.htm?id=${item.idKategorie}"/>" class="delete">
                                <img src="<c:url value="/images/icon-delete.png"/>" alt="<fmt:message key="button.delete" />" title="<fmt:message key="button.delete" />"/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

<script type="text/javascript">
    $(document).ready(function() {
        $('a.delete').click(function() {
            return confirm('<fmt:message key="delete.confirmation" />');
        });
    });
</script>
