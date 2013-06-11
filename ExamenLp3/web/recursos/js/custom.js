$(document).ready(function(){	
	my_kwicks();
	//Index menus
	$(".menuitem").click(enlace_menu);
	$(".mnu a").click(enlace_menu);		
	//$("#contenedor").corner("cc:#c0c0c0"); 
    $("#contenedor #menu").corner();	
    $("#contenedor #pie").corner();
});

function my_kwicks(){
    $('.kwicks').kwicks({
		duration: 300,   
        max: 200,  
        spacing:  0  
    });
}

function enlace_menu(){            
        var pagina=$(this).attr("href"); 
        //alert(pagina);
	$("#cuerpo").html('<center><img src="recursos/ajax-loader.gif">Cargando...</center>');
        $("#cuerpo").load(pagina);
	return false;
}
function fn_mostrar(){
	$("#cuerpo").load("listarEstudiantes.php");
}

function fn_paginar(var_div, url){
	var div = $("#" + var_div);
	$(div).load(url);
}

function loading(){
	$("#cuerpo").html('<center><img src="recursos/ajax-loader.gif"></center>');
}

