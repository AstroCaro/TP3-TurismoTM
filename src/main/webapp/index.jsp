<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<script defer src="assets/js/puntos-rojos.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="assets/css/estilos-inicio.css">

<title>Turismo en la Tierra Media - Inicio</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<div id="inicio" class="container-fluid mt-5">
		<div class="row d-flex justify-content-center mt-5">
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
			<div class="col-3 d-flex justify-content-center tipo-atraccion">
				<h2>Aventura</h2>
			</div>
			<div class="col-3 d-flex justify-content-center tipo-atraccion">
				<h2>Degustación</h2>
			</div>
			<div class="col-3 d-flex justify-content-center tipo-atraccion">
				<h2>Paisaje</h2>
			</div>
		</div>
	</div>
	<div class="container mt-5">
		<div class="row">
			<div class="col-4 d-flex">
				<div id=carruselAtracciones class="carousel slide carousel-dark"
					data-bs-ride="carousel">
					<div class="carousel-inner">
						<c:forEach items="${atracciones}" var="atraccion">
							<c:choose>
								<c:when test="${atraccion.id_atraccion == 1}">
									<div class="carousel-item active data-bs-interval="1500"">
								</c:when>
								<c:otherwise>
									<div class="carousel-item data-bs-interval="1500"">
								</c:otherwise>
							</c:choose>
							<div class="card h-100">
								<!-- <a class="text-decoration-none"
									href="atracciones/verAtraccion.do?id_atraccion=${atraccion.id_atraccion }">
									 -->
								<img src="assets/img/${atraccion.nombre}/1.jpg"
									class="card-img-top imagen-carrusel" alt="${atraccion.nombre}">
								<!--</a> -->
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
			<div class="col-8 d-flex">
				<div id="container-mapa">
					<img src="assets/img/mapa.png" alt="mapa" id="img-mapa"> <a
						href="/TurismoTMTP3/atracciones/verAtraccion.do?id_atraccion=1"
						class="punto-rojo" style="left: 33%; top: 35%;"> <img
						src="assets/img/etiquetas/Moria.png" class="etiqueta-atraccion">
					</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>