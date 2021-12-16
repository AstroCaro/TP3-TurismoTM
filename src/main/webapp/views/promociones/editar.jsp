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
<script type="text/javascript">
	
</script>
<title>Crear Promoción</title>
</head>
<body class="fondo">
	<jsp:include page="/partials/nav_lateral_admin.jsp"></jsp:include>
	<main>
		<jsp:include page="/partials/nav_top_admin.jsp"></jsp:include>
		<div class="contenido">
			<div class="container">
				<h1>Crear Promoción</h1>
			</div>
			<c:if test="${promocion != null && !promocion.isValid()}">
				<div class="alert alert-danger">
					<p>Se encontraron errores al crear la promocion.</p>
				</div>
			</c:if>
			<form action="/TurismoTMTP3/promociones/edit.do" method="post">
				<input type="hidden" name="id_promocion"
					value="${promocion.id_promocion}">
				<jsp:include page="/views/promociones/form_edit.jsp"></jsp:include>
			</form>
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