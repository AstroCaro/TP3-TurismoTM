/*$(document).on('change', '#cantidadAtracciones', function() {
	var shouldEnable = $(this).val() !== '3';
	$('#atracciones3').prop('disabled', shouldEnable);
});*/

$(document).ready(function() {
	$("#cantidadAtracciones").on("change", function() {
		if ($(this).val() == "2") {
			$("#atraccion1").show();
			$("#atraccion2").show();
		}
		else if ($(this).val() == "3") {
			$("#atraccion1").show();
			$("#atraccion2").show();
			$("#atraccion3").show();
		} else if ($(this).val() == "ninguno") {
			$("#atraccion1").hide();
			$("#atraccion2").hide();
			$("#atraccion3").hide();
		}
	});
});


$(document).ready(function() {
	$("#tipoPromocion").on("change", function() {
		if ($(this).val() === "PromocionAbsoluta") {
			$("#input1").show();
		}
		else {
			$("#input1").hide();
		}

		if ($(this).val() === "PromocionAXB") {
			$("#input2").show();
		}
		else {
			$("#input2").hide();
		}

		if ($(this).val() === "PromocionPorcentual") {
			$("#input3").show();
		}
		else {
			$("#input3").hide();
		}
	});
});