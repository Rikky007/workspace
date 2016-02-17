<%--
JSP stranka slozici pro zobrazeni formulare.
--%>
<c:set var="formUrl"><c:url value="/album-save.htm" /></c:set>
<%--
    Formular generovany pomoci spring tagu. Dulezity atribut je commandName, ktery musi odpovidat 
    jmenu, ktere nastavujeme v kontroleru.
--%>
<form:form action="${formUrl}" commandName="albumCommand" method="post" acceptCharset="UTF-8">
    <%--
    input hidden generovany pomoci spring tagu form:hidden. Dulezity je atrubut path, ktery musi odpovidat 
    tridni promenne respektive jejimu gettru (musime tam tedy najit getIdKategorie potazmo setIdKategorie)      
    --%>
    <form:hidden path="albumid" />
    <table class="form">
        <tbody>
            <tr>
                <td><fmt:message key="album.label.title" /></td>
                <td>
                    <form:input path="title" />
                    <%--
                    Tento tag slouzi pro zobrazeni chyb. Kdyz nastavime atribut path na konkretni jmeno, zobrazi jen chybu pro tuto
                    polozku. Pokud bychom pouzili hvezdicku, zobrazi vsechny chyby.
                    --%>
                    <form:errors path="title" element="span" />
                </td>
            </tr>
            <tr>
                <td><fmt:message key="album.label.artist" /></td>
                <td>
                    <form:select path="artist">
                        <c:forEach items="${artists}" var="art">
                            <form:option value="${art.name}" label="${art.name}"/>
                        </c:forEach>
                    </form:select>
                    <form:errors path="artist" element="span" />
                </td>
            </tr>
            <tr>
                <td><fmt:message key="album.label.genre" /></td>
                <td>
                    <form:select path="genre">
                        <c:forEach items="${genres}" var="gen">
                            <form:option value="${gen.name}" label="${gen.name}"/>
                        </c:forEach>
                    </form:select>

                    <form:errors path="artist" element="span" />
                </td>
            </tr>
            <tr>
                <td><fmt:message key="album.label.price" /></td>
                <td>
                    <form:input path="price" />
                    <%--
                    Tento tag slouzi pro zobrazeni chyb. Kdyz nastavime atribut path na konkretni jmeno, zobrazi jen chybu pro tuto
                    polozku. Pokud bychom pouzili hvezdicku, zobrazi vsechny chyby.
                    --%>
                    <form:errors path="price" element="span" />
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td class="submit" colspan="2"><input type="submit" value="<fmt:message key="button.save" />" /></td>
            </tr>
        </tbody>
    </table>
</form:form>