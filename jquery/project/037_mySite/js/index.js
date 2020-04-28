$(document).ready(function(){

	//登录和注册切换
	$('.toggle').click(function(){
		$(this).children('i').toggleClass('fa-pencil');
		$('.form').animate({height: "toggle",'padding-top': 'toggle','padding-bottom': 'toggle',opacity: "toggle"}, "slow");
	});

	//关闭弹出层
	$('.tooltip').click(function(){
		$('.login').css("display","none");
		$(this).css("display","none");
	});

	//注册点击事件
	$(".nav-register").click(function(){
		$('.login').css("display","block");
		$('.tooltip').css("display","block");
		$(".form").css("display","block");
		$(".form:eq(0)").css("display", "none");
	});

	//登录点击事件
	$(".nav-login").click(function(){
		$('.login').css("display","block");
		$(".form").css("display","block");
		$('.tooltip').css("display","block");
		$(".form:eq(1)").css("display", "none");
	});
});
