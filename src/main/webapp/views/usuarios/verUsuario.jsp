<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>

<link rel="stylesheet" type="text/css"
	href="../assets/css/datatables/datatables.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script defer type="text/javascript" charset="utf8"
	src="../assets/js/datatables/datatables.min.js"></script>
<script type="text/javascript" src="../assets/js/datatables/spanish.js"></script>
<jsp:include page="/partials/head_admin.jsp"></jsp:include>
<title>Ver Usuario</title>
</head>
<body class="fondo">
	<jsp:include page="/partials/nav_lateral_admin.jsp"></jsp:include>
	<main>
		<jsp:include page="/partials/nav_top_admin.jsp"></jsp:include>
		<div class="contenido">
			<div class="container">
				<h1>${usuario.nombre}</h1>
			</div>
		</div>
	<div class="container">
		<table id="table_id" class="display">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Preferencia</th>
					<th>Presupuesto</th>
					<th>Tiempo Disponible</th>
					<th>Admin</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${usuario.id_usuario}"></c:out></td>
					<td><c:out value="${usuario.nombre}"></c:out></td>
					<td><c:out value="${usuario.getPreferencia().getTipoAtraccion()}"></c:out></td>
					<td><c:out value="${usuario.presupuesto}"></c:out></td>
					<td><c:out value="${usuario.tiempo_disponible}"></c:out></td>
					<td><c:out value="${usuario.admin ? 'Si' : 'No'}"></c:out></td>
				</tr>
			</tbody>
		</table>
	</div>
</main>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>
</body>
</html>