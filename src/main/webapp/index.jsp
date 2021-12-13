<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.img-circular {
	border-radius: 50%;
	height: 100;
	width: auto;
}
</style>
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap/bootstrap.css">
<script defer src="assets/js/bootstrap/bootstrap.js"
	type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="assets/css/datatables/datatables.css">

<script defer src="asses/js/mapa.js" type="text/javascript"></script>
<script defer src="assets/js/puntos-rojos.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="assets/css/estilo-mapa.css">
<title>Turismo en la Tierra Media - Inicio</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row d-flex justify-content-center">
			<div class="col-3 d-flex justify-content-center">
				<img src="assets/img/aventura.jpg" alt="aventura"
					class="img-circular">
			</div>
			<div class="col-3 d-flex justify-content-center">
				<img src="assets/img/degustacion.jpg" alt="degustacion"
					class="img-circular">
			</div>
			<div class="col-3 d-flex justify-content-center">
				<img src="assets/img/paisaje.jpg" alt="paisaje" class="img-circular">
			</div>
		</div>
		<div class="row d-flex justify-content-center">
			<div class="col-3 d-flex justify-content-center">
				<h2>Aventura</h2>
			</div>
			<div class="col-3 d-flex justify-content-center">
				<h2>Degustación</h2>
			</div>
			<div class="col-3 d-flex justify-content-center">
				<h2>Paisaje</h2>
			</div>
		</div>
	</div>
	<div class="container mt-5">
		<div class="row">
			<div class="col-4">
				<div id=carruselAtracciones class="carousel slide align-middle"
					data-bs-ride="carousel">

					<div class="carousel-inner">
						<div class="carousel-item active">
							<div class="card h-100">
								<img src="assets/img/Moria/1.jpg" class="card-img-top"
									alt="Moria">
								<div class="card-body">
									<h5 class="card-title">
										<c:out value="Moria"></c:out>
									</h5>
									<p class="card-text">
										<c:out
											value="Situada en la Colina de la Guardía, se encuentra rodeada de tierras fértiles que van desde sus muros hasta Rammas Echor"></c:out>
									</p>
								</div>
							</div>
						</div>
						<c:forEach items="${atracciones}" var="atraccion">
							<c:choose>
								<c:when test="${atraccion.id_atraccion == 1}">
									<div class="carousel-item active">
								</c:when>
								<c:otherwise>
									<div class="carousel-item">
								</c:otherwise>
							</c:choose>
							<div class="card h-100">
								<img src="assets/img/${atraccion.nombre}/1.jpg"
									class="card-img-top" alt="${atraccion.nombre}">
								<div class="card-body">
									<h5 class="card-title">
										<c:out value="${atraccion.nombre}"></c:out>
									</h5>
									<p class="card-text">
										<c:out value="${atraccion.descripcion}"></c:out>
									</p>
								</div>
							</div>
					</div>
					</c:forEach>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carruselAtracciones" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carruselAtracciones" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
		<div class="col-8">
			<div id="container-mapa">
				<img src="assets/img/mapa.png" alt="mapa" id="img-mapa">
				<a href="/TurismoTMTP3/atracciones/verAtraccion.do?id_atraccion=1"
					class="punto-rojo" style="left: 33%; top: 35%;"><img
					src="assets/img/etiquetas/Moria.png" class="etiqueta-atraccion"></a>
			</div>
		</div>
	</div>
	</div>
</body>
</html>