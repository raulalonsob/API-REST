<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
	<h2>Gestión de colegio</h2>
	<%@include file="../../menu.html"%>
	
	<div class="container">
		<h2>Listado de asignaturas</h2>
		<div class="form">
			<form action="http://localhost:8080/colegio/listadoasignaturas" method="post">
				<label for="id">Id Asignatura</label> 
				<input type="text" id="id"	name="id"> 
				<label for="nombre">Nombre Asignatura</label> 
				<input type="text" id="nombre" name="nombre">
				<br> 
				<label for="curso">Curso</label> 
				<input type="text" id="curso" name="curso">
				<label for="curso">Tasa</label> 
				<input type="text" id="tasa" name="tasa">
				
				<input type="submit" value="Buscar">
			</form>

		</div>
		
		<table>
		
		<tr>
			<th>Id</th>
			<th>Nombre Asignatura</th>
			<th>Curso</th>
			<th>Tasa</th>
		</tr>
		
		<c:forEach items="${lista}" var="asignatura">
			<tr>
				<td> ${asignatura.id}</td>
				<td> ${asignatura.nombre}</td>
				<td> ${asignatura.curso }</td>
				<td> ${asignatura.tasa }</td>
			</tr>
		</c:forEach>

	</table>

	</div>
	


</body>
</html>