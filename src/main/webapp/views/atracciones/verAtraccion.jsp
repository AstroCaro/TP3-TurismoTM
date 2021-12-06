<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<title>${atraccion.nombre}</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
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
					<img src="../assets/img/${atraccion.nombre}/1.jpg" class="d-block w-100"
						alt="...">
				</div>
				<div class="carousel-item">
					<img src="../assets/img/${atraccion.nombre}/2.jpg" class="d-block w-100"
						alt="...">
				</div>
				<div class="carousel-item">
					<img src="../assets/img/${atraccion.nombre}/3.jpg" class="d-block w-100"
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