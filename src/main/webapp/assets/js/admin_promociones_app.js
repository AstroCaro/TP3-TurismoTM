/*$(document).on('change', '#cantidadAtracciones', function() {
	var shouldEnable = $(this).val() !== '3';
	$('#atracciones3').prop('disabled', shouldEnable);
});*/

$(document).ready(function() {
	$("#cantidadAtracciones").on("change", function() {
		if ($(this).val() == "2") {
			$("#atraccion1").show().find('select').attr('required', true);
			$("#atraccion2").show().find('select').attr('required', true);
			$("#atraccion3").hide().find('select').attr('required', false);

		} else if ($(this).val() == "3"){
			$("#atraccion1").show().find('select').attr('required', true);
			$("#atraccion2").show().find('select').attr('required', true);
			$("#atraccion3").show().find('select').attr('required', true);
		} else {
			$("#atraccion1").hide().find('select').attr('required', false);
			$("#atraccion2").hide().find('select').attr('required', false);
			$("#atraccion3").hide().find('select').attr('required', false);
		}

	});
});


$(document).ready(function() {
	$("#tipoPromocion").on("change", function() {
		if ($(this).val() === "PromocionAbsoluta") {
			$("#input1").show().find('input').attr('required', true);
		}
		else {
			$("#input1").hide().find('input').attr('required', false);
		}

		if ($(this).val() === "PromocionAxB") {
			$("#input2").show().find('select').attr('required', true);
		}
		else {
			$("#input2").hide().find('select').attr('required', false);
		}

		if ($(this).val() === "PromocionPorcentual") {
			$("#input3").show().find('input').attr('required', true);
		}
		else {
			$("#input3").hide().find('input').attr('required', false);;
		}
	});
});