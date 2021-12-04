<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
Object atraccion = request.getAttribute("atraccion");
%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<script defer src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<title>${atraccion.nombre}</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-2">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">TurismoTM</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarText"
					aria-controls="navbarText" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarText">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="lista-atracciones.html">Lista de Atracciones</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
						</li>
					</ul>
					<span class="navbar-text"> Texto bonito a la derecha </span>
				</div>
			</div>
		</nav>
	</div>
	<div class="container">
		<div id="carouselExampleIndicators" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleIndicators"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="img/${atraccion.nombre}/1.jpg" class="d-block w-100"
						alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/${atraccion.nombre}/2.jpg" class="d-block w-100"
						alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/${atraccion.nombre}/3.jpg" class="d-block w-100"
						alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
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
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${atraccion.id_atraccion}"></c:out></td>
					<td><c:out value="${atraccion.nombre}"></c:out></td>
					<td><c:out value="${atraccion.costo}"></c:out></td>
					<td><c:out value="${atraccion.tiempo}"></c:out></td>
					<td><c:out value="${atraccion.cuposDisponibles}"></c:out></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>