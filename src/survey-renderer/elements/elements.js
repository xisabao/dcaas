$(document).ready(function() {
	$(".datepicker").datepicker();
	$(".slider").slider({
		min: 1,
		max: 10,
		value: 5,
		slide: function(event, ui) {
			$(".slider-amount").val(ui.value);
		}
	});
	$(".slider-amount").val($(".slider").slider("value"))
});