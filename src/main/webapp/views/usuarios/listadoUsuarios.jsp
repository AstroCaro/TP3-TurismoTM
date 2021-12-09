<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="/partials/head.jsp"></jsp:include>

<link rel="stylesheet" type="text/css"
	href="../assets/css/datatables.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script defer type="text/javascript" charset="utf8"
	src="../assets/js/datatables.min.js"></script>
<title>Listado de Usuarios</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>		
	<div class="container">
		<div class="bg-light p-4 mb-3 rounded">
			<h1>Listado de Usuarios</h1>
		</div>
	</div>
	<div class="container">
		<div class="mb-3">
			<a href="/TurismoTMTP3/usuarios/crear.do" class="btn btn-primary"
				role="button"> <i class="bi bi-plus-lg"></i> Nuevo Usuario
			</a>
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
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td><c:out value="${usuario.id_usuario}"></c:out></td>
						<td><c:out value="${usuario.nombre}"></c:out></td>
						<td><c:out value="${usuario.getPreferencia().getTipoAtraccion()}"></c:out></td>
						<td><c:out value="${usuario.presupuesto}"></c:out></td>
						<td><c:out value="${usuario.tiempo_disponible}"></c:out></td>
						<td><c:out value="${usuario.admin ? 'Si' : 'No'}"></c:out></td>				

						<td>
							<a href="/TurismoTMTP3/usuarios/verUsuario.do?id_usuario=${usuario.id_usuario}"
								class="btn btn-success rounded" role="button">Ver Usuario</a>
							<a href="/TurismoTMTP3/usuarios/editar.do?id_usuario=${usuario.id_usuario}"
								class="btn btn-light rounded-0" role="button">Editar
								<i class="bi bi-pencil-fill"></i></a>
							<a href="/TurismoTMTP3/usuarios/delete.do?id_usuario=${usuario.id_usuario}"
								class="btn btn-danger rounded" role="button">Eliminar
								<i class="bi bi-x-circle-fill"></i></a>
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