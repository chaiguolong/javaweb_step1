$(function(){
	$("#btn1").click(function(){
		$("body div").css("background-color","gold");
	});

	$("#btn2").click(function(){
		$("body>div").css("background-color","gold");
	});

	$("#btn3").click(function(){
		$("#two+div").css("background-color","gold");
	});

	$("#btn4").click(function(){
		$("#one~div").css("background-color","gold");
	});
});
