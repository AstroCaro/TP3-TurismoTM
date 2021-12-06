<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${usuario != null && !usuario.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar el usuario.</p>
			</div>
		</c:if>

		<form action="/TurismoTMTP3/usuarios/editar.do" method="post">
			<input type="hidden" name="id_usuario" value="${usuario.id_usuario}">
			<jsp:include page="/views/usuarios/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
