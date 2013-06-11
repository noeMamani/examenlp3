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
    <div align="center">
        <s:form id="form" name="form" method="post" action="imprimir" theme="simple" target="print">
        mes<s:select name="mes" list="{'TODOS','01','02','03','04','05','06','07','08','09','10','11','12'}"/>          
        año <s:select name="año" list="{'2013','2012','2011','2011'}"/>      
        <s:submit value="Buscar" cssClass="button mediun orange"/>
    </s:form>
    </div>
    <div id="div_listar">    </div>
</body>
<table align="center"><tr><td><iframe width="700px" height="750px" name="print"></iframe></td></tr></table>
</html>