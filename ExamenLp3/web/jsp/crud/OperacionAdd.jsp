<%-- 
    Document   : estudianteAdd
    Created on : 14-feb-2013, 23:33:41
    Author     : AngelDX
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
        $(document).ready(function(){		
            $("#frm").validate({
		submitHandler: function(form) {                                
                $.ajax({
           		type: 'POST',
            		url: $("#frm").attr('action'),
            		data: $("#frm").serialize(),
			beforeSend: loading,					
            		success: function(data) {                            
                            $("#cuerpo").html(data);
          		}			
		});
                return false;
		}
            });
        });            
        </script>        
    </head>
    <body>
        <h1><s:text name="nuevo.titulo"/></h1>
        <div align="center">
        <s:form action="agregarEstudiante" id="frm">
            <s:push value="estudiante">
            <s:hidden name="id"/>    
            <s:textfield name="nombres" key="nuevo.nombres" cssClass="required" required="true" title="Ingrese nombre"/>
            <s:textfield name="apellidos" key="nuevo.apellidos"/>
            <s:textfield name="dni" key="nuevo.dni" size="9" maxlength="8"/>
            <s:radio name="tcolegio" list="{'PARTICULAR','ESTATAL'}" key="nuevo.tcolegio"/>
            <s:textfield name="ncolegio" key="nuevo.ncolegio"/>
            <s:select name="categoria" list="{'A','B','C','D'}" key="nuevo.categoria"/>
            <s:reset key="nuevo.btn.limpiar" cssClass="button mediun blue"/>
            <s:submit key="nuevo.btn.registrar" cssClass="button mediun blue"/>
            </s:push>
        </s:form>
        </div>    
    </body>
</html>
