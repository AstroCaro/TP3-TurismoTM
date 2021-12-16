<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/estilo_panel_administrador.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/admin_app.js" defer></script>
<script src="https://kit.fontawesome.com/7cc28fa7fa.js"
	crossorigin="anonymous"></script>
<title>Panel de administración</title>
</head>
<body class="fondo">
	<jsp:include page="partials/nav_lateral_admin.jsp"></jsp:include>
	<main>
		<jsp:include page="partials/nav_top_admin.jsp"></jsp:include>
		<div class="contenido">
			<h1>Panel de Administracion</h1>
			<p class="text">Lorem ipsum dolor sit amet consectetur
				adipisicing elit. Explicabo voluptatibus iusto aliquam repudiandae
				perspiciatis officia atque reprehenderit distinctio maxime sint
				ratione consequatur sapiente repellendus quo doloribus cumque
				numquam dolores, ex earum quidem in alias exercitationem. Iste eos
				tempore ea reprehenderit debitis. Autem nisi optio saepe soluta
				culpa fuga a enim quidem excepturi. Aliquam soluta sunt perspiciatis
				alias fugiat? Eum, quam.</p>
		</div>
		<div class="copyright">
			<p>
				&copy; 2021 -
				<span>GrupoNULL</span>
				Todos los derechos reservados.
			</p>
		</div>
	</main>
</body>
</html>