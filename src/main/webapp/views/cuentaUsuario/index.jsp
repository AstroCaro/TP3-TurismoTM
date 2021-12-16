<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script>
	$(function() {
		$("#slider-range").slider(
				{
					range : true,
					min : 0,
					max : 200,
					values : [ 75, 150 ],
					slide : function(event, ui) {
						$('.ui-slider-handle:eq(0) .price-range-min').html(
								'<img src="assets/img/usuario/coin.png">'
										+ ui.values[0]);
						$('.ui-slider-handle:eq(1) .price-range-max').html(
								'<img src="assets/img/usuario/coin.png">'
										+ ui.values[1]);
					}
				});
		$('.ui-slider-handle:eq(0)')
				.append(
						'<div> <span class="price-range-min value"><img src="assets/img/usuario/coin.png">'
								+ $('#slider-range').slider('values', 0)
								+ '</span></div>');
		$('.ui-slider-handle:eq(1)')
				.append(
						'<div><span class="price-range-max value"><img src="assets/img/usuario/coin.png">'
								+ $('#slider-range').slider('values', 1)
								+ '</span></div>');
	});
</script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet" href="assets/css/estilos_cuenta_usuario.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous" defer></script>
<script type="text/javascript" src="assets/js/usuario_app.js" defer></script>
<script src="https://kit.fontawesome.com/7cc28fa7fa.js"
	crossorigin="anonymous"></script>
<title><c:out value="${usuario.nombre}" />, en la Tierra Media
</title>
<%-- <% String username = (String) session.getAttribute("username"); %> --%>
</head>
<body>
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
					<li class="nav-item">
						<a class="nav-link" aria-current="page" href="#">INICIO</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">ATRACCIONES</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">PROMOCIONES</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">CONTACTO</a>
					</li>
				</ul>
			</div>
			<div class=" navbar-nav order-md-last nav-items-derecha"
				id="navbarSupportedContent">
				<ul class="nav navbar-nav  mb-2 mb-lg-0">
					<li class="nav-item action">
						<a class="nav-link profile" aria-current="page" href="#">
							<div class="icon">
								<i class='bx bx-user'></i>
								<i class='bx bxs-user'></i>
							</div>
						</a>
						<div class="menu-usuario fondo">
							<h3>
								<c:out value="${usuario.nombre}" />
							</h3>
							<h5>Administrador de TurismoTM</h5>
							<ul>
								<li>
									<a href="#">
										<i class='bx bx-user-circle'></i>
										<span>Mi Perfil</span>
									</a>
								</li>
								<li>
									<a href="#">
										<i class='bx bx-cog'></i>
										<span>Configuracion</span>
									</a>
								</li>
								<li>
									<a href="logout">
										<i class='bx bx-log-out'></i>
										<span>Cerrar Sesion</span>
									</a>
								</li>
							</ul>
						</div>
					</li>
					<li class="nav-item action">
						<a class="nav-link mapa" aria-current="page" href="#">
							<div class="icon">
								<i class='bx bx-map-alt'></i>
								<i class='bx bxs-map-alt'></i>
							</div>
						</a>
						<div class="itinerario fondo">
							<div class="after"></div>
							<!-- TODO modelo de objeto nulo para itinerario -->
							<c:choose>
								<c:when test="${empty itinerario}">
									<h5 class="text-center">Su itinerario se encuentra vacio.
										No esperes más, armá tu próxima travesía.</h5>
								</c:when>
								<c:when test="${not empty itinerario}">
									<!-- otherwise -->
									<h5>Tu itinerario incluye</h5>
									<ul>
										<c:forEach items="${itinerario}" var="ofertaComprada">
											<li>
												<div class="card mb-3"
													style="max-width: 500px; max-height: 200px;">
													<div class="row g-0">
														<div class="col-md-3">
															<c:choose>
																<c:when test="${ofertaComprada.esPromocion()}">
																	<img
																		src="assets/img/promociones/PromocionPorcentual1.jpeg"
																		class="itinerario-img img-fluid rounded-start cover"
																		alt="...">
																</c:when>
																<c:when test="${ofertaComprada.esAtraccion()}">
																	<img src="assets/img/atracciones/LaComarca.jpg"
																		class="itinerario-img img-fluid rounded-start cover"
																		alt="...">
																</c:when>
																<c:otherwise>
																	<img src="assets/img/atracciones/marannon.jpg"
																		class="itinerario-img img-fluid rounded-start cover"
																		alt="...">
																</c:otherwise>
															</c:choose>
														</div>
														<div class="col-md-6">
															<div class="card-body">
																<small>
																	<p class="text-muted">
																		<c:out value="${ofertaComprada.getClase()}"></c:out>
																	</p>
																</small>
																<h5 class="card-title">
																	<c:out value="${ofertaComprada.nombre}"></c:out>
																</h5>
																<p class="card-text">
																	<c:out
																		value="${fn:substring(ofertaComprada.descripcion,0,80)}"></c:out>
																	...
																</p>
															</div>
														</div>
														<div class="col-md-3 col-detalles">
															<div class="detalles">
																<div class="costo">
																	<img alt="" src="assets/img/usuario/coins.png">
																	<span>
																		<c:out value="${ofertaComprada.costo}"></c:out>
																		monedas
																	</span>
																</div>
																<div class="tiempo">
																	<img alt="" src="assets/img/usuario/reloj.png">
																	<span>
																		<c:out value="${ofertaComprada.tiempo}"></c:out>
																		horas
																	</span>
																</div>
															</div>
														</div>
													</div>
												</div>
											</li>
										</c:forEach>
									</ul>
									<div class="total">
										<h3>Total:</h3>
										<div class="total-detalles">
											<div class="costo">
												<img alt="" src="assets/img/usuario/coins.png">
												<span>
													<c:out value="${usuario.getItinerario().getMontoTotal()}"></c:out>
													monedas
												</span>
											</div>
											<div class="tiempo">
												<img alt="" src="assets/img/usuario/reloj.png">
												<span>
													<c:out value="${usuario.itinerario.horasTotales}"></c:out>
													horas
												</span>
											</div>
										</div>
									</div>
									<div class="ver-itinerario">
										<a href="#">
											<span>Ver detalle de itinerario</span>
											<div>
												<i class='bx bxs-right-arrow-alt'></i>
											</div>
										</a>
									</div>
								</c:when>
							</c:choose>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<!-- <span class="navbar-text small text-truncate mt-1 text-end order-1 order-md-last">always show</span> -->
	</nav>
	<main>
		<section id="inicio" class="row">
			<div class="info-usuario ">
				<div>
					<p>
						Bienvenido,
						<c:out value="${usuario.nombre}" />
					</p>
				</div>
				<div class="perfil row">
					<div class="col-3">
						<div class="perfil-imagen">
							<img src="assets/img/usuario/gandalf.jpg" alt="">
						</div>
						<a href="logout">
							<div class="perfil-logout">
								<div class="icon">
									<i class='bx bx-log-out'></i>
								</div>
							</div>
						</a>
						<a href="#">
							<div class="perfil-editar">
								<div class="icon">
									<i class='bx bx-pencil'></i>
								</div>
							</div>
						</a>
					</div>
					<div class="perfil-resumen col-9">
						<div class="perfil-presupuesto">
							<div class="card mb-3" style="max-width: 540px;">
								<div class="row g-0">
									<div class="col-md-8">
										<h5 class="card-title">Presupuesto</h5>
										<div class="card-body" style="display:ruby">
											<img alt="" src="assets/img/usuario/coins.png">
											<h2 class="card-text">${usuario.presupuesto}</h2>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="perfil-tiempo">
							<div class="card mb-3" style="max-width: 540px;">
								<div class="row g-0">
									<div class="col-md-8">
										<h5 class="card-title">Tiempo Disponible</h5>
										<div class="card-body" style="display:ruby">
											<img alt="" src="assets/img/usuario/reloj.png">
											<h2 class="card-text">${usuario.tiempo_disponible}</h2>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="row pt-5">
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
						<c:if test="${errors != null}">
							<ul>
								<c:forEach items="${errors}" var="entry">
									<li>
										<c:out value="${entry.getValue()}"></c:out>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</p>
				</div>
			</c:if>
			<div class="col-3" id="filtros-bar">
				<div class="filtros-header">
					<h5>Filtros</h5>
					<hr class="dropdown-divider">
				</div>
				<div id="custom-accord">
					<div class="accordion" id="accordionPanelsStayOpenExample">
						<div class="accordion-item">
							<h2 class="accordion-header" id="panelsStayOpen-headingOne">
								<button class="accordion-button" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseOne"
									aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">TIPO
									DE OFERTA</button>
							</h2>
							<div id="panelsStayOpen-collapseOne"
								class="accordion-collapse collapse show"
								aria-labelledby="panelsStayOpen-headingOne">
								<div class="accordion-body">
									<ul>
										<li>
											<label>
												<input type="checkbox">
												Promoción
											</label>
										</li>
										<li>
											<label>
												<input type="checkbox">
												Atracción
											</label>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="panelsStayOpen-headingTwo">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseTwo"
									aria-expanded="false"
									aria-controls="panelsStayOpen-collapseTwo">TIPO DE
									ATRACCIÓN</button>
							</h2>
							<div id="panelsStayOpen-collapseTwo"
								class="accordion-collapse collapse"
								aria-labelledby="panelsStayOpen-headingTwo">
								<div class="accordion-body">
									<ul>
										<li>
											<label>
												<input type="checkbox">
												Aventura
											</label>
										</li>
										<li>
											<label>
												<input type="checkbox">
												Degustación
											</label>
										</li>
										<li>
											<label>
												<input type="checkbox">
												Paisaje
											</label>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="panelsStayOpen-headingThree">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseThree"
									aria-expanded="false"
									aria-controls="panelsStayOpen-collapseThree">RANGO DE
									PRECIOS</button>
							</h2>
							<div id="panelsStayOpen-collapseThree"
								class="accordion-collapse collapse"
								aria-labelledby="panelsStayOpen-headingThree">
								<div class="accordion-body rango-precios">
									<div>
										<img id="img-rango" alt="" src="assets/img/usuario/rango.png">
									</div>
									<div id="slider-range"></div>
								</div>
							</div>
						</div>
						<div class="accordion-item">
							<h2 class="accordion-header" id="panelsStayOpen-headingThree">
								<button class="accordion-button collapsed" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapseFour"
									aria-expanded="false"
									aria-controls="panelsStayOpen-collapseFour">DURACIÓN</button>
							</h2>
							<div id="panelsStayOpen-collapseFour"
								class="accordion-collapse collapse"
								aria-labelledby="panelsStayOpen-headingFour">
								<div class="accordion-body">
									<ul>
										<li>
											<label>
												<input type="checkbox">
												Menos de 1 hora
											</label>
										</li>
										<li>
											<label>
												<input type="checkbox">
												1-2 horas
											</label>
										</li>
										<li>
											<label>
												<input type="checkbox">
												2-4 horas
											</label>
										</li>
										<li>
											<label>
												<input type="checkbox">
												Más de 4 horas
											</label>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-9" id="ofertas">
				<div class="row row-cols-1 row-cols-md-3 ">
					<c:forEach items="${ofertas}" var="oferta">
						<div class="col card-group">
							<div class="card h-100">
								<c:if test="${oferta.tipoAtraccion==usuario.preferencia}">
									<div class="tag-preferencia">
										<i class='bx bx-heart'></i>
									</div>
								</c:if>
								<div class="tag"
									style="background-color: var(--color-${fn:toLowerCase(oferta.tipoAtraccion.tipoAtraccion)});--color:var(--color-${fn:toLowerCase(oferta.tipoAtraccion.tipoAtraccion)}); --color-sombra:var(--color-sombra-${fn:toLowerCase(oferta.tipoAtraccion.tipoAtraccion)});">
									<p class="tipo-atraccion">
										<c:out value="${oferta.tipoAtraccion.tipoAtraccion}"></c:out>
									</p>
								</div>
								<div class="card-img">
									<c:choose>
										<c:when
											test="${usuario.puedeComprar(oferta) && usuario.puedeAsistir(oferta) && oferta.tieneCupo()}">
											<div class="boton-agregar">
												<c:choose>
													<c:when test="${oferta.esAtraccion()}">
														<a
															href="agregarAtraccionAItinerario.do?id=${oferta.id_atraccion}">
															<input type="button" value="AGREGAR A ITINERARIO">
														</a>
													</c:when>
													<c:when test="${oferta.esPromocion()}">
														<a
															href="agregarPromocionAItinerario.do?id=${oferta.id_promocion}">
															<input type="button" value="AGREGAR A ITINERARIO">
														</a>
													</c:when>
												</c:choose>
											</div>
										</c:when>
										<c:when
											test="${ ! oferta.tieneCupo() && usuario.puedeComprar(oferta) && usuario.puedeAsistir(oferta)}">
											<div class="boton-deshabilitado">
												<a href="#">
													<input class="btn btn-secondary" type="button"
														value="OFERTA NO DISPONIBLE">
												</a>
											</div>
										</c:when>
										<c:when
											test="${oferta.tieneCupo() && ! usuario.puedeComprar(oferta) && usuario.puedeAsistir(oferta)}">
											<div class="boton-deshabilitado">
												<a href="#">
													<input class="btn btn-secondary" type="button"
														value="MONEDAS INSUFICIENTES">
												</a>
											</div>
										</c:when>
										<c:when
											test="${oferta.tieneCupo() && usuario.puedeComprar(oferta) && ! usuario.puedeAsistir(oferta)}">
											<div class="boton-deshabilitado">
												<a href="#">
													<input class="btn btn-secondary" type="button"
														value="TIEMPO INSUFICIENTE">
												</a>
											</div>
										</c:when>
										<c:otherwise>
											<div class="boton-deshabilitado">
												<a href="#">
													<input class="btn btn-secondary" type="button"
														value="NO SE PUEDE COMPRAR">
												</a>
											</div>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${oferta.esPromocion()}">
											<img src="assets/img/promociones/PromocionPorcentual1.jpeg"
												class="card-img-top" alt="...">
										</c:when>
										<c:when test="${oferta.esAtraccion()}">
											<img src="assets/img/atracciones/LaComarca.jpg"
												class="card-img-top" alt="...">
										</c:when>
										<c:otherwise>
											<img src="assets/img/atracciones/marannon.jpg"
												class="card-img-top" alt="...">
										</c:otherwise>
									</c:choose>
								</div>
								<div class="card-body">
									<small>
										<p class="text-muted">
											<c:out value="${oferta.getClase()}"></c:out>
										</p>
									</small>
									<a href="">
										<h5 class="card-title">
											<c:out value="${oferta.nombre}"></c:out>
										</h5>
									</a>
									<p class="card-text">
										<c:out value="${fn:substring(oferta.descripcion,0,120)}"></c:out>
										...
										<c:if test="${oferta.esPromocion()}">
											<ul class="card-text">
												<c:forEach items="${oferta.atracciones}" var="atraccion">
													<li>
														<c:out value="${atraccion.nombre}"></c:out>
													</li>
												</c:forEach>
											</ul>
										</c:if>
									</p>
								</div>
								<div class="card-footer">
									<div class="costo">
										<img alt="" src="assets/img/usuario/coins.png">
										<span>
											<c:out value="${oferta.costo}"></c:out>
											monedas
										</span>
									</div>
									<div class="tiempo">
										<img alt="" src="assets/img/usuario/reloj.png">
										<span>
											<c:out value="${oferta.tiempo}"></c:out>
											horas
										</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
	</main>
</body>
</html>