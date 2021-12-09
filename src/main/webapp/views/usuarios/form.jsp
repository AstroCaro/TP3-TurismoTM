<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="nombre" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="nombre" name="nombre" required
			value="${usuario.nombre}">
	</div>
	<div class="mb-3">
		<label for="preferencia" class="col-form-label">Preferencia:</label> <select
			class="form-control" name="preferencia" id="preferencia" required>
			<option value="1">Aventura</option>
			<option value="2">Degustacion</option>
			<option value="3">Paisaje</option>
		</select>
	</div>
	<div class="mb-3">
		<label for="password" class="col-form-label">Contraseña:</label> <input
			type="password" class="form-control" id="password" name="password" required
			value="${usuario.password}">
	</div>
	<div class="mb-3">
		<label for="presupuesto"
			class='col-form-label ${usuario.errors.get("presupuesto") != null ? "is-invalid" : "" }'>Presupuesto:</label>
		<input class="form-control" type="number" id="presupuesto"
			name="presupuesto" required value="${usuario.presupuesto}"></input>
		<div class="invalid-feedback">
			<c:out value='${usuario.errors.get("presupuesto")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="tiempo_disponible"
			class='col-form-label ${usuario.errors.get("tiempo_disponible") != null ? "is-invalid" : "" }'>Tiempo
			Disponible:</label> <input class="form-control" type="number"
			id="tiempo_disponible" name="tiempo_disponible" required
			value="${usuario.tiempo_disponible}"></input>
		<div class="invalid-feedback">
			<c:out value='${usuario.errors.get("tiempo_disponible")}'></c:out>
		</div>
	</div>
	<div class="mb-3">		
		<label class="form-check-label" for="admin">Administrador   </label>
			
			<input class="form-check-input" type="checkbox" value="true"
				id="admin" name="admin"> 
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
