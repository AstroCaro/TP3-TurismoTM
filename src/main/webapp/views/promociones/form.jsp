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
		<textarea class="form-control" id="descripcion"
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
	<div class="mb-3">
		<label for="cantidadAtracciones" class="col-form-label">Cantidad
			de atracciones:</label>
		<select class="form-select" name="cantidadAtracciones"
			id="cantidadAtracciones" required>
			<option value="ninguno" selected>Selecciona...</option>
			<c:forEach begin="2" end="4" var="cantidad">
			<option value="${cantidad}" ${cantidad == grade ? 'selected' : ''}>${cantidad}</option>
			</c:forEach>
		</select>
	</div>

<%-- 	<form:select path="selectName">
		<form:option value="0" label="Select an Option" />
		<form:options items="${nameOfList}" />
	</form:select> --%>
	<%-- <div class="mb-3" id="atraccion1">
		<label for="atracciones1" class="col-form-label">Atraccion 1</label>
		<select class="form-select" name="atracciones1" id="atracciones1"
			required>
			<option selected>Selecciona...</option>
			<c:forEach items="${atracciones}" var="atraccion">
				<option value="${atraccion.id_atraccion}">${atraccion.nombre}</option>
			</c:forEach>
		</select>
	</div>
	<div class="mb-3" id="atraccion2">
		<label for="atracciones2" class="col-form-label">Atraccion 2</label>
		<select class="form-select" name="atracciones2" id="atracciones2"
			required>
			<option selected>Selecciona...</option>
			<c:forEach items="${atracciones}" var="atraccion">
				<option value="${atraccion.id_atraccion}">${atraccion.nombre}</option>
			</c:forEach>
		</select>
	</div>
	<div class="mb-3" id="atraccion3">
		<label for="atracciones3" class="col-form-label">Atraccion 3</label>
		<select class="form-select atracciones3" name="atracciones3"
			id="atracciones3" required>
			<option selected>Selecciona...</option>
			<c:forEach items="${atracciones}" var="atraccion">
				<option value="${atraccion.id_atraccion}">${atraccion.nombre}</option>
			</c:forEach>
		</select>
	</div> --%>
	<div id="input-atracciones">
	</div>
	<div class="mb-3">
		<label for="tipoPromocion" class="col-form-label">Tipo de
			Promocion:</label>
		<select class="form-select" name="tipoPromocion" id="tipoPromocion"
			required>
			<option selected>Selecciona...</option>
			<option value="PromocionAbsoluta">Promocion Absoluta</option>
			<option value="PromocionAXB">Promocion AxB</option>
			<option value="PromocionPorcentual">Promocion Porcentual</option>
		</select>
	</div>
	<div class="mb-3" id="input1">
		<label for="costo" class="col-form-label">Costo:</label>
		<input type="text" class="form-control" id="costo" name="costo"required">
	</div>
	<div class="mb-3" id="input2">
		<label for="atraccionGratis" class="col-form-label">Atraccion
			Gratis:</label>
		<input type="text" class="form-control" id="atraccionGratis"
			name="atraccionGratis"required">
	</div>
	<div class="mb-3" id="input3">
		<label for="descuento" class="col-form-label">Descuento:</label>
		<input type="number" step="0.01" min=0 class="form-control"
			id="descuento" name="descuento"required">
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
</div>
