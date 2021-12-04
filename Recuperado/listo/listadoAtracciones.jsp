<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/assets/css/datatables.min.css">


<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script defer src="/assets/js/bootstrap.min.js"></script>

<script defer type="text/javascript" charset="utf8"
	src="/assets/js/datatables.min.js"></script>

<title>Tablero de Atracciones</title>
</head>
<body>
	<div class="container">
		<table id="table_id" class="display">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Costo</th>
					<th>Tiempo</th>
					<th>Cupo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atracciones}" var="atraccion">
					<tr>
						<td><c:out value="${atraccion.id_atraccion}"></c:out></td>
						<td><c:out value="${atraccion.nombre}"></c:out></td>
						<td><c:out value="${atraccion.costo}"></c:out></td>
						<td><c:out value="${atraccion.tiempo}"></c:out></td>
						<td><c:out value="${atraccion.cuposDisponibles}"></c:out></td>
						<td><button form="formulario" value="${atraccion.id_atraccion}" name="boton">Ver
								Atracción</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form id="formulario" action="mostrar-atraccion" method="GET"></form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>
</body>
</html>