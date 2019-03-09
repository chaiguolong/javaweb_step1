$(function(){
	$("#btn1").click(function(){
		$("#one").css("background-color","pink");
	});

	$("#btn2").click(function(){
		$(".mini").css("background-color","pink");
	});

	$("#btn3").click(function(){
		$("div").css("background-color","pink");
	});

	$("#btn4").click(function(){
		$("*").css("background-color","pink");
	});

	$("#btn5").click(function(){
		$("#two,.mini").css("background-color","pink");
	});
});
