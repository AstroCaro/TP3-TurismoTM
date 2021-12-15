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
		<label for="tipoAtraccion" class="col-form-label">Tipo de
			Atraccion:</label>
		<select class="form-select" name="tipoAtraccion" id="tipoAtraccion"
			required>
			<option value="1">Aventura</option>
			<option value="2">Degustacion</option>
			<option value="3">Paisaje</option>
		</select>
	</div>
	<div class="mb-3">
		<label for="tipoPromocion" class="col-form-label">Tipo de
			Promocion:</label>
		<select class="form-select" name="tipoPromocion" id="tipoPromocion"
			required>
			<option value="PromocionAbsoluta">Promocion Absoluta</option>
			<option value="PromocionAXB">Promocion AxB</option>
			<option value="PromocionPorcentual">Promocion Porcentual</option>
		</select>
	</div>
	<div class="mb-3">
		<label for="tipoPromocion" class="col-form-label">Tipo de
			Promocion:</label>
		<select class="form-select" name="tipoPromocion" id="tipoPromocion"
			required>
			<option value="1">2</option>
			<option value="2">3</option>
		</select>
	</div>
	<div class="mb-3">
		<label for="tipoPromocion" class="col-form-label">Tipo de
			Promocion:</label>
		<select class="form-select" name="atracciones" id="atracciones"
			required>
			<c:forEach items="${atracciones}" var="atraccion">
				<option value="${atraccion.id_atraccion}">${atraccion.nombre}</option>
			</c:forEach>
		</select>
	</div>
	<%-- 	<div class="mb-3">
		<label for="costo"
			class='col-form-label ${promocion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="costo" name="costo"
			required value="${promocion.costo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("costo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="tiempo"
			class='col-form-label ${atraccion.errors.get("tiempo") != null ? "is-invalid" : "" }'>Tiempo:</label>
		<input class="form-control" type="number" id="tiempo" name="tiempo"
			required value="${atraccion.tiempo}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("tiempo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="cuposDisponibles"
			class='col-form-label ${atraccion.errors.get("cuposDisponibles") != null ? "is-invalid" : "" }'>Cupos
			Disponibles:</label>
		<input class="form-control" type="number" id="cuposDisponibles"
			name="cuposDisponibles" required
			value="${atraccion.cuposDisponibles}"></input>
		<div class="invalid-feedback">
			<c:out value='${atraccion.errors.get("cuposDisponibles")}'></c:out>
		</div>
	</div>
</div> --%>
	<div>
		<button type="submit" class="btn btn-primary">Guardar</button>
		<a onclick="window.history.back();" class="btn btn-secondary"
			role="button">Cancelar</a>
	</div>