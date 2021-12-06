<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="nombre" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="nombre" name="nombre"
			required value="${usuario.nombre}">
	</div>
	<div class="mb-3">
		<label for="preferencia" class="col-form-label">Preferencia:</label> <input
			type="text" class="form-control" id="preferencia" name="preferencia"
			required value="${usuario.preferencia}">
	</div>
	<div class="mb-3">
		<label for="presupuesto"
			class='col-form-label ${usuario.errors.get("presupuesto") != null ? "is-invalid" : "" }'>Presupuesto:</label>
		<input class="form-control" type="number" id="presupuesto" name="presupuesto"
			required value="${usuario.presupuesto}"></input>
		<div class="invalid-feedback">
			<c:out value='${usuario.errors.get("presupuesto")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="tiempo_disponible"
			class='col-form-label ${usuario.errors.get("tiempo_disponible") != null ? "is-invalid" : "" }'>Tiempo Disponible:</label>
		<input class="form-control" type="number" id="tiempo_disponible" name="tiempo_disponible"
			required value="${usuario.tiempo_disponible}"></input>
		<div class="invalid-feedback">
			<c:out value='${usuario.errors.get("tiempo_disponible")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="admin"
			class="col-form-label">Admin:</label>
		<input class="form-control" type="text" id="admin" name="admin"
			required value="${usuario.admin}"></input>
		<div class="invalid-feedback">
			<c:out value='${usuario.errors.get("admin")}'></c:out>
		</div>
	</div>
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
