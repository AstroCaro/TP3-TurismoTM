<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<script defer src="${pageContext.request.contextPath}/assets/js/puntos-rojos.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/estilos-inicio.css">

<title>Turismo en la Tierra Media - Atracciones</title>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<div class="container mt-5">
		<c:forEach items="${atracciones}" var="atraccion">
			<div class="card h-100">
				<a class="text-decoration-none"
									href="${pageContext.request.contextPath}/atracciones/verAtraccion.do?id_atraccion=${atraccion.id_atraccion }">
				<img src="${pageContext.request.contextPath}/assets/img/${atraccion.nombre}/1.jpg"
					class="card-img-top imagen-carrusel" alt="${atraccion.nombre}">
				</a>
				<div class="card-body">
					<h5 class="card-title">
						<c:out value="${atraccion.nombre}"></c:out>
					</h5>
					<p class="card-text">
						<c:out value="${atraccion.descripcion}"></c:out>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>