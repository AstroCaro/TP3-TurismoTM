<nav>
	<div class="menulateral-top">
		<img src="../assets/img/logo.png" class="logo" alt="">
		<h3 class="oculto">TierraMedia</h3>
	</div>
	<div class="buscador">
		<i class='bx bx-search'></i>
		<input type="text" class="oculto" placeholder="Buscar...">
	</div>
	<div class="menu-links">
		<ul>
			<div class="active-tab"></div>
			<li class="elemento-tooltip" data-tooltip="0">
				<a href="#" class="" data-active="0">
					<div class="icon">
						<i class='bx bx-layout'></i>
						<i class='bx bxs-layout'></i>
					</div>
					<span class="link oculto">Tablero</span>
				</a>
			</li>
			<li class="elemento-tooltip" data-tooltip="1">
				<a href="${pageContext.request.contextPath}/usuarios/listadoUsuarios.do" data-active="1">
					<div class="icon">
						<i class="far fa-address-card"></i>
						<i class="fas fa-address-card"></i>
					</div>
					<span class="link oculto">Usuarios</span>
				</a>
			</li>
			<li class="elemento-tooltip" data-tooltip="2">
				<a href="${pageContext.request.contextPath}/atracciones/listadoAtracciones.do" data-active="2">
					<div class="icon">
						<i class='bx bx-landscape'></i>
						<i class='bx bxs-landscape'></i>
					</div>
					<span class="link oculto">Atracciones</span>
				</a>
			</li>
			<li class="elemento-tooltip" data-tooltip="3">
				<a href="${pageContext.request.contextPath}/promociones/listadoPromociones.do" data-active="3">
					<div class="icon">
						<i class='bx bx-box'></i>
						<i class='bx bxs-box'></i>
					</div>
					<span class="link oculto">Promociones</span>
				</a>
			</li>
			<li class="elemento-tooltip" data-tooltip="4">
				<a href="#" data-active="4">
					<div class="icon">
						<i class='bx bx-collection'></i>
						<i class='bx bxs-collection'></i>
					</div>
					<span class="link oculto">Tipo de atracciones</span>
				</a>
			</li>
			<div class="tooltip">
				<span class="mostrar">Tablero</span>
				<span>Usuarios</span>
				<span>Atracciones</span>
				<span>Promociones</span>
				<span>Tipo de atracciones</span>
			</div>
		</ul>
	</div>
</nav>