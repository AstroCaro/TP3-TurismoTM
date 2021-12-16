<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="../assets/css/bootstrap/bootstrap.css">
<script defer src="../assets/js/bootstrap/bootstrap.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="../assets/css/datatables/datatables.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="resources/demos/style.css">
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet" href="../assets/css/estilos_cuenta_usuario.css">
<script src="https://kit.fontawesome.com/7cc28fa7fa.js"
	crossorigin="anonymous"></script>
<style type="text/css">
#carruselVerAtraccion {
	width: 80%;
	heigth: auto;
}

.font-family-ringbearer {
	font-family: "ringbearer", sans-serif;
}
</style>

<title>${atraccion.nombre}</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<div class="container d-flex justify-content-center mt-5">
		<div id="carruselVerAtraccion" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="../assets/img/${atraccion.nombre}/1.jpg"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="../assets/img/${atraccion.nombre}/2.jpg"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="../assets/img/${atraccion.nombre}/3.jpg"
						class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="carruselVerAtraccion" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="carruselVerAtraccion" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
	<div class="container mt-5">
		<p class="text-center fs-1 font-family-ringbearer">${atraccion.nombre}</p>
		<p class="text-center fs-3 font-family-ringbearer">${atraccion.descripcion}</p>
	</div>
	<div class="container mt-5 d-flex justify-content-center">
		<table id="table_id" class="table">
			<tbody>
				<tr class="d-flex justify-content-center">
					<th class="col-3 d-flex justify-content-center">Atracción</th>
					<td class="col-3 d-flex justify-content-center"><c:out value="${atraccion.nombre}"></c:out></td>
				</tr>
				<tr class="d-flex justify-content-center">
					<th class="col-3 d-flex justify-content-center">Costo</th>
					<td class="col-3 d-flex justify-content-center"><c:out value="${atraccion.costo}"></c:out></td>
				</tr>
				<tr class="d-flex justify-content-center">
					<th class="col-3 d-flex justify-content-center">Duración</th>
					<td class="col-3 d-flex justify-content-center"><c:out value="${atraccion.tiempo}"></c:out></td>
				</tr>
				<tr class="d-flex justify-content-center">
					<th class="col-3 d-flex justify-content-center">Cupos</th>
					<td class="col-3 d-flex justify-content-center"><c:out value="${atraccion.cuposDisponibles}"></c:out></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>