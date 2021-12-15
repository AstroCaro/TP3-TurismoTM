<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<script type="text/javascript">
$(document).on('change', '#cantidadAtracciones', function(){
    var shouldEnable = $(this).val() !== '3';
    $('#atracciones3').prop('disabled', shouldEnable);
});

$(document).ready(function() {
    $("#tipoPromocion").on("change", function() {
        if ($(this).val() == "Promocion Absoluta") {
            $("#input1").show();
        }
        else {
            $("#input1").hide();
        }
        
    });
    
});
</script>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${promocion != null && !promocion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear la promocion.</p>
			</div>
		</c:if>

		<form action="/TurismoTMTP3/promociones/crear.do" method="post">
			<jsp:include page="/views/promociones/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
