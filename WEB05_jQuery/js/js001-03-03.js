$(function(){
	$("#btn1").click(function(){
		$("body div:first").css("background-color","red");
	});
	
	$("#btn2").click(function(){
		$("body div:last").css("background-color","red");
	});
	
	$("#btn3").click(function(){
		$("body div:odd").css("background-color","red");
	});
	
	$("#btn4").click(function(){
		$("body div:even").css("background-color","red");
	});
});
