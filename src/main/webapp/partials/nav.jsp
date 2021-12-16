<div class="container">
	<nav
		class="navbar navbar-expand-md navbar-costum navbar-light fixed-top">
		<div class="container-fluid">
			<div class="d-flex  order-0">
				<a class="navbar-brand me-1 fs-2" href="#">Tierra Media</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div
				class="navbar-collapse collapse justify-content-between order-2 nav-items-centrales"
				id="navbarSupportedContent">
				<ul class="navbar-nav nav-fill w-100">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/inicio">INICIO</a></li>
					<li class="nav-item"><a class="nav-link"
						href="#carruselAtracciones">ATRACCIONES</a></li>
					<li class="nav-item"><a class="nav-link" href="#">PROMOCIONES</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">CONTACTO</a>
					</li>
				</ul>
			</div>
			<div class=" navbar-nav order-md-last nav-items-derecha"
				id="navbarSupportedContent">
				<ul class="nav navbar-nav  mb-2 mb-lg-0">
					<li class="nav-item action"><a class="nav-link profile"
						aria-current="page" href="#">
							<div class="icon">
								<i class='bx bx-user'></i> <i class='bx bxs-user'></i>
							</div>
					</a>
						<div class="menu-usuario fondo">
							<h3>
								<c:out value="${username}" />
							</h3>
							<h5>Administrador de TurismoTM</h5>
							<ul>
								<li><a href="#"> <i class='bx bx-user-circle'></i> <span>Mi
											Perfil</span>
								</a></li>
								<li><a href="#"> <i class='bx bx-cog'></i> <span>Configuracion</span>
								</a></li>
								<li><a href="logout"> <i class='bx bx-log-out'></i> <span>Cerrar
											Sesion</span>
								</a></li>
							</ul>
						</div></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="#">
							<div class="icon">
								<i class='bx bx-map-alt'></i> <i class='bx bxs-map-alt'></i>
							</div>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>