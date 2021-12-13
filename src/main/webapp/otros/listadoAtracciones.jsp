<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="../assets/css/datatables/datatables.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script defer type="text/javascript" charset="utf8"
	src="../assets/js/datatables/datatables.min.js"></script>
<title>Tablero de Atracciones</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<div class="container">
		<div class="bg-light p-4 mb-3 rounded">
			<h1>Listado de atracciones de la Tierra Media</h1>
		</div>
	</div>
	<div class="container">
		<div class="mb-3">
			<a href="/TurismoTMTP3/atracciones/crear.do" class="btn btn-primary"
				role="button">
				<i class="bi bi-plus-lg"></i>
				Nueva Atracción
			</a>
		</div>
	</div>
	<div class="container">
		<table id="table_id" class="display">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Costo</th>
					<th>Tiempo</th>
					<th>Cupo</th>
					<th>Tipo Atracción</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atracciones}" var="atraccion">
					<tr>
						<td>
							<c:out value="${atraccion.id_atraccion}"></c:out>
						</td>
						<td>
							<c:out value="${atraccion.nombre}"></c:out>
						</td>
						<td>
							<c:out value="${atraccion.costo}"></c:out>
						</td>
						<td>
							<c:out value="${atraccion.tiempo}"></c:out>
						</td>
						<td>
							<c:out value="${atraccion.cuposDisponibles}"></c:out>
						</td>
						<td>
							<c:out value="${atraccion.tipoAtraccion.getTipoAtraccion()}"></c:out>
						</td>
						<td>
							<a
								href="/TurismoTMTP3/atracciones/verAtraccion.do?id_atraccion=${atraccion.id_atraccion}"
								class="btn btn-success rounded" role="button">Ver Atracción</a>
							<a
								href="/TurismoTMTP3/atracciones/edit.do?id_atraccion=${atraccion.id_atraccion}"
								class="btn btn-light rounded-0" role="button">
								Editar
								<i class="bi bi-pencil-fill"></i>
							</a>
							<a
								href="/TurismoTMTP3/atracciones/delete.do?id_atraccion=${atraccion.id_atraccion}"
								class="btn btn-danger rounded" role="button">
								Eliminar
								<i class="bi bi-x-circle-fill"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>
</body>
</html>