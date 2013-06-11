<%-- 
    Document   : index
    Created on : 03/06/2013, 10:02:12 AM
    Author     : Alumno
--%>
<script type="text/javascript" src="recursos/js/angeldx.js"></script>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <s:form action="verificar" >
            <s:textfield name="usuario" label="Usuario"/>
            <s:password name="password" label="Pasword"/>
            <s:submit />
         </s:form>
    </body>
</html>
