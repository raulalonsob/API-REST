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
<h2>Insertar alumno</h2>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/colegio/insertaralumno" method="post" id="formulario">
				<label for="id">DNI Alumno</label> 
				<input type="text" id="id"	name="id"> 
				<label for="nombre">Nombre Alumno</label> 
				<input type="text" id="nombre" name="nombre"><br> 
				
				<select name="municipios" form="formulario" >		
					<c:forEach items="${listaMunicipios}" var="municipio">			
						<option value="${municipio.id}"> ${municipio.descripcion} </option>
					</c:forEach>
				</select>
				<br>
				<label for="familiaNumerosa">Familia numerosa</label>
				<input type="checkbox" id="familiaNumerosa" name="familiaNumerosa" value="1">
				
				<input type="submit" value="Enviar">
			</form>
		</div>
		
		<c:if test="${resultado == 1}">
			<b>Alumno insertado correctamente</b>
		</c:if>

	</div>



</body>
</html>