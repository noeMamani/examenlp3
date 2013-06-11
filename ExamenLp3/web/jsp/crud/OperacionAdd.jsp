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
        <s:form action="agregarOperacion" id="frm">
           <s:push value="operacion">
           <s:hidden name="id"/>    
           <s:textfield label="id_persona" name="id_persona" />
           <s:textfield label="id_sucursal" name="id_sucursal" />
           <s:textfield label="id_consepto" name="id_consepto" />
           <s:textfield label="comprobante" name="comprobante" />
           <s:textfield label="numero" name="numero" />
           <s:textfield label="catidad" name="catidad" />
           <s:textfield label="descripcion" name="descripcion" />
           <s:textfield label="ingreso" name="ingreso" />
           <s:textfield label="egreso" name="egreso" />
           
            <s:reset key="nuevo.btn.limpiar" cssClass="button mediun blue"/>
            <s:submit key="nuevo.btn.registrar" cssClass="button mediun blue"/>
            </s:push>
        </s:form>
        </div>    
    </body>
</html>
