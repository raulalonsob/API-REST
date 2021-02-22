<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="css/index.css">
	 <link rel="stylesheet" href="css/formularios.css">
</head>
<body>
<header>
<h2>Gestión de Colegio</h2>
</header>

<%@include file="../../menu.html" %>

	<div class="container">
		<h2>Insertar asignatura</h2>
		<div class="form">
			<form action="http://localhost:8080/colegio/insertarasignatura" method="post" id="formulario">
				<label for="id">Id</label> 
				<input type="text" id="id"	name="id"> 
				<label for="nombre">Nombre Asignatura</label> 
				<input type="text" id="nombre" name="nombre">				
				<label for="nombre">Curso</label> 
				<input type="text" id="curso" name="curso"><br> 
				<label for="nombre">Tasa</label> 
				<input type="text" id="tasa" name="tasa">
				
				<input type="submit" value="Añadir">
			</form>
		</div>
		
		<c:if test="${resultado == 1}">
			<b>Asignatura insertada correctamente</b>
		</c:if>

	</div>



</body>
</html>