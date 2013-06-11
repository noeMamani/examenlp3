<%-- 
    Document   : estudianteRptMain
    Created on : 25-feb-2013, 10:40:06
    Author     : AngelDX
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<script type="text/javascript">
$(document).ready(function(){	
});
</script>
</script>        
    </head>
<body>
    <a href="imprimir">reportar </a>
    <div align="center">
        <s:form id="form" name="form" method="post" action="imprimir" theme="simple" target="print">
        <s:submit value="Buscar" cssClass="button mediun orange"/>
    </s:form>
    </div>
    <div id="div_listar">    </div>
</body>
<table align="center"><tr><td><iframe width="700px" height="750px" name="print"></iframe></td></tr></table>
</html>