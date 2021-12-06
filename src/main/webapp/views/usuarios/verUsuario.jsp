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
	</div>
	<div class="container">
		<table id="table_id" class="display">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Preferencia</th>
					<th>Presupuesto</th>
					<th>Tiempo Disponible</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${usuario.id_usuario}"></c:out></td>
					<td><c:out value="${usuario.nombre}"></c:out></td>
					<td><c:out value="${usuario.preferencia}"></c:out></td>
					<td><c:out value="${usuario.presupuesto}"></c:out></td>
					<td><c:out value="${usuario.tiempo}"></c:out></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>