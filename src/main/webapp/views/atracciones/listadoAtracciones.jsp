<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
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
<title>Listado de Atracciones</title>
</head>
<body class="fondo">
	<jsp:include page="/partials/nav_lateral_admin.jsp"></jsp:include>
	<main>
		<jsp:include page="/partials/nav_top_admin.jsp"></jsp:include>
		<div class="contenido">
			<div class="container">
				<h1>Listado de Atracciones</h1>
			</div>
			<div class="container">
				<div class="mb-3">
					<a href="/TurismoTMTP3/atracciones/crear.do"
						class="btn btn-primary" role="button">
						<i class="bi bi-plus-lg"></i>
						Nueva Atracción
					</a>
				</div>
			</div>
			<div class="container">
				<div class="table-responsive">
					<table class="datatable table table-hover table-striped"
						id="table_id" class="display">
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
											class="btn btn-success rounded" role="button">
											<i class="far fa-eye"></i>
										</a>
										<a
											href="/TurismoTMTP3/atracciones/edit.do?id_atraccion=${atraccion.id_atraccion}"
											class="btn btn-secondary rounded" role="button">
											<i class="fas fa-pencil-alt"></i>
										</a>
										<a
											href="/TurismoTMTP3/atracciones/delete.do?id_atraccion=${atraccion.id_atraccion}"
											class="btn btn-danger rounded" role="button">
											<i class="fas fa-trash-alt"></i>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="copyright">
			<p>
				&copy; 2021 -
				<span>GrupoNULL</span>
				Todos los derechos reservados.
			</p>
		</div>
	</main>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>
</body>
</html>