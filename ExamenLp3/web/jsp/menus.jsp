<%-- 
    Document   : index
    Created on : 14-feb-2013, 21:58:26
    Author     : AngelDX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="recursos/js/angeldx.js"></script>
<title>.:Gestión de Consurso v1.0:.</title>
</head>
<body>
<div id="contenedor" style="width:80%;margin:0 auto;">
    <div id="menu" align="center" class="menu">
     <ul class="kwicks">  
         <li id="kwick1"><a href="listarOperacion" class="menuitem">Operaciones </a></li>  
         
         <li id="kwick4"><a href="jsp/estudianteRptMain.jsp" class="menuitem">Impresión</a></li>  
     </ul> 
        
<!--        <a href="${pageContext.request.contextPath}/locale?request_locale=es" class="menuitem" style="color: white; border-bottom: 1px dotted white;">|<img src="recursos/icon/pe.png"/>Español|</a>
        <a href="${pageContext.request.contextPath}/locale?request_locale=en" class="menuitem" style="color: white; border-bottom: 1px dotted white;">|<img src="recursos/icon/us.png"/>Ingles|</a>        
    -->
    </div>
    <div id="cuerpo"><!-- Aca se muestra las páginas--></div>
    <div id="pie" class="pie"> 
        <article>
    
        </article>
    </div>
</div>
</body>
</html>
