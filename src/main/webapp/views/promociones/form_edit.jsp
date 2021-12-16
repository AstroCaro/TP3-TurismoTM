<%@page import="services.AtraccionService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="aService" class="services.AtraccionService" />
<%pageContext.setAttribute("atracciones", aService.listar());%>
<div class="modal-body">
	<div class="mb-3">
		<label for="nombre" class="col-form-label">Nombre:</label>
		<input type="text" class="form-control" id="nombre" name="nombre"
			required value="${promocion.nombre}">
	</div>
	<div class="mb-3">
		<label for="descripcion" class="form-label">Descripcion</label>
		<textarea class="form-control" id="descripcion" name="descripcion"
			placeholder="Descripcion" required> ${promocion.descripcion}</textarea>
	</div>
	<div class="mb-3">
		<label for="tipoAtraccion" class="col-form-label">Tipo de
			Atraccion:</label>
		<select class="form-select" name="tipoAtraccion" id="tipoAtraccion"
			required>
			<option value="1">Aventura</option>
			<option value="2">Degustacion</option>
			<option value="3">Paisaje</option>
		</select>
	</div>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>