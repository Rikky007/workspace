<%--
JSP stranka slozici pro zobrazeni formulare.
--%>
<c:set var="formUrl"><c:url value="/kategorie-save.htm" /></c:set>
<%--
    Formular generovany pomoci spring tagu. Dulezity atribut je commandName, ktery musi odpovidat 
    jmenu, ktere nastavujeme v kontroleru.
--%>
<form:form action="${formUrl}" commandName="kategorieCommand" method="post" acceptCharset="UTF-8">
    <%--
    input hidden generovany pomoci spring tagu form:hidden. Dulezity je atrubut path, ktery musi odpovidat 
    tridni promenne respektive jejimu gettru (musime tam tedy najit getIdKategorie potazmo setIdKategorie)      
    --%>
    <form:hidden path="idKategorie" />
    <table class="form">
        <tbody>
            <tr>
                <td class="pp"><fmt:message key="category.label.name" /></td>
                <td>
                    <form:input path="nazev" />
                    <%--
                    Tento tag slouzi pro zobrazeni chyb. Kdyz nastavime atribut path na konkretni jmeno, zobrazi jen chybu pro tuto
                    polozku. Pokud bychom pouzili hvezdicku, zobrazi vsechny chyby.
                    --%>
                    <form:errors path="nazev" element="span" />
                </td>
            </tr>
            <tr>
                <td class="np"><fmt:message key="category.label.description" /></td>
                <td><form:textarea path="popis" cols="40" rows="10" /></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td class="submit" colspan="2"><input type="submit" value="<fmt:message key="button.save" />" /></td>
            </tr>
        </tbody>
    </table>
</form:form>