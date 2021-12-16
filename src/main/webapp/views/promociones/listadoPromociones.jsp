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
<jsp:include page="/partials/head_admin_promociones.jsp"></jsp:include>
<title>Listado de Promociones</title>
</head>
<body class="fondo">
	<jsp:include page="/partials/nav_lateral_admin.jsp"></jsp:include>
	<main>
		<jsp:include page="/partials/nav_top_admin.jsp"></jsp:include>
		<div class="contenido">
			<div class="container">
				<h1>Listado de Promociones</h1>
			</div>
			<div class="container">
				<div class="mb-3">
					<a href="/TurismoTMTP3/promociones/crear.do"
						class="btn btn-primary" role="button">
						<i class="bi bi-plus-lg"></i>
						Nueva Promocion
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
								<th>Tipo de Promocion</th>
								<th>Tipo de Atracción</th>
								<th>Tiempo</th>
								<th>Costo</th>
								<th>Cupo</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${promociones}" var="promocion">
								<tr>
									<td>
										<c:out value="${promocion.id_promocion}"></c:out>
									</td>
									<td>
										<c:out value="${promocion.nombre}"></c:out>
									</td>
									<td>
										<c:out value="${promocion['class']['simpleName']}"></c:out>
									</td>
									<td>
										<c:out value="${promocion.tipoAtraccion.tipoAtraccion}"></c:out>
									</td>
									<td>
										<c:out value="${promocion.tiempo}"></c:out>
									</td>
									<td>
										<c:out value="${promocion.costo}"></c:out>
									</td>
									<td>
										<c:out value="${promocion.cuposDisponibles}"></c:out>
									</td>
									<td>
										<a
											href="/TurismoTMTP3/promociones/verPromocion.do?id_promocion=${promocion.id_promocion}"
											class="btn btn-success rounded" role="button">
											<i class="far fa-eye"></i>
										</a>
										<a
											href="/TurismoTMTP3/promociones/edit.do?id_promocion=${promocion.id_promocion}"
											class="btn btn-secondary rounded" role="button">
											<i class="fas fa-pencil-alt"></i>
										</a>
										<a
											href="/TurismoTMTP3/promociones/delete.do?id_promocion=${promocion.id_promocion}"
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