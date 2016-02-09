<%--
JSP stranka pro zobrazeni vyjimky. Zobrazi se obecny text a odkaz, kterym lze zobrazit vice informaci, coz
je vypis stacktracu. Div s vice informacemi se zobrazuje/schovava pomoci Java\Scriptu
--%>
<fmt:message key="exception.info" /> <br>

<a href="javascript:;" id="show-exception-detail"><fmt:message key="more.info" /></a>

<div id="exception-detail" style="display: none;">
    ${exceptionstr}
</div>

<script type="text/javascript">
    $(document).ready(function(){
        $('a#show-exception-detail').click(function(){
            var exDetail = $('div#exception-detail');
            
            if (exDetail.css('display') === 'none') {
                exDetail.show();
            } else {
                exDetail.hide();
            }
        });
    });
</script>