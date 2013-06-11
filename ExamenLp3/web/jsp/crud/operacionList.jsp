<%-- 
    Document   : estudiantesList
    Created on : 14-feb-2013, 22:09:51
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
    function fn_nuevo(){
        var pagina=$("#nu").attr("href");        
        loading();        
        $("#cuerpo").load(pagina);                
        return false;
    }
    
    function fn_editar(id){
        var pagina=$("#ed").attr("href");        
        loading();        
        $("#cuerpo").load(pagina+"?id="+id);                
        return false;
    }
    
    function fn_eliminar(id){
        if(confirm("¿Desea Eliminar el Registro?")){
            var pagina=$("#el").attr("href");        
            loading();        
            $("#cuerpo").load(pagina+"?id="+id);
            return false;
        }
        return false;
    }
    </script>
    </head>
    <body>
        <h1><s:text name="Lista Operacion" /></h1>
   <s:if test="lista.size() > 0">
       <table class="lista">
            <thead>
		<tr>
			<th>#</th>
                        <th><s:text name="concepto"/></th>
			<th><s:text name="descripcion"/></th>
			<th><s:text name="fecha Movimiento"/></th>
			<th><s:text name="ingreso"/></th>
			<th><s:text name="egreso"/></th>
			<th colspan="2">                                                      
                            <a href="nuevoOperacion" id="nu" onclick="return fn_nuevo()"><img src="recursos/icon/add.png"/></a>
                        </th>    
		</tr>
            </thead>
            <tbody>
		<s:iterator value="lista" status="estStatus">
			<tr
				class="<s:if test="#estStatus.odd==true">odd</s:if><s:else>even</s:else>">
				<td><s:property value="#estStatus.index+1" /></td>
                                <td><s:property value="desc_con" /></td>
				<td><s:property value="descripcion" /></td>
				<td><s:property value="fecha" /></td>
				<td><s:property value="ingreso" /></td>
				<td><s:property value="egreso" /></td>
                              <td><s:url id="editURL" action="editarOperacion">
                                       <%// <s:param name="id" value="%{id}"></s:param> %>
                                    </s:url>
                                    <s:a href="%{editURL}" id="ed" onclick="return fn_editar(%{id})"><img src="recursos/icon/pencil.png"/></s:a>
                                </td>
				<td><s:url id="deleteURL" action="eliminarOperacion">
                                        <%//<s:param name="id" value="%{id}"></s:param> %>
                                    </s:url>
                                    <s:a href="%{deleteURL}" id="el" onclick="return fn_eliminar(%{id})"><img src="recursos/icon/delete.png"/></s:a>
                                </td>                                    
				
			</tr>
		</s:iterator>
            </tbody>
	</table>
</s:if>
    </body>
</html>
