<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css"
	href="assets/css/estilos_login.css">
<link rel="icon" href="icon.png">
<title>Ingreso a Turismo TM</title>
</head>
<body>
	<section id="inicio">
		<div id="box">
			<div id="contendor">
				<div id="form">
					<h2>Login</h2>
					<form action="login" method="post">
						<div class="inputBx">
							<input type="text" placeholder="Usuario" name="username">
							<img src="assets/img/login/user.png">
						</div>
						<div class="inputBx">
							<input type="password" placeholder="Contraseña" name="password">
							<img src="assets/img/login/lock.png">
						</div>
						<c:if test="${flash != null}">

							<div class="error">
								<p>
									<c:out value="${flash}" />
								</p>
							</div>
						</c:if> 
						<%-- <% String flash = (String) request.getAttribute("flash");%>
						<% if (flash!=null) {%>
						<div class="error"><%= flash %></div><%}%> --%>
						<label id="recordar"> <input type="checkbox">
							Recordarme
						</label>
						<div class="inputBx inputSubmit">
							<input type="submit" value="Ingresar">
						</div>
					</form>
					<p>
						<a href=""> Olvidé mi contraseña </a>
					</p>
					<p>
						<a href="">Registrarme</a>
					</p>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
