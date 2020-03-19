$(function(){
	//获取原始的倍数,数字1
	var begin = parseInt($(".multiple").html());
	//给class为add的绑定点击事件
	$(".add").click(function(){
		begin++;
		$(".multiple").html(begin);
	});
	//给class为reduce的绑定点击事件
	$(".reduce").click(function(){
		if(begin > 1){
			begin--;
		}
		$(".multiple").html(begin);
	});
	//滑动横条的绑定
	//1.给每一个元素设置index
	$(".bl-b ul li").attr("index", function(i, e){
		return i;
	});

	//2.为每个横条绑定hover事件
	$(".bl-b ul li").hover(function(){
		var index = $(this).attr("index");
		$(".bl-t ul li:not(.movebox)").hide();
		$(".bl-t ul li:eq("+index+")").show();
		//放大层全部隐藏
		$(".br ul li").hide();
		//方大层选中的层显示
		$(".br ul li:eq("+index+")").show();
		$(this).siblings().css("border", "2px solid #fff");
		$(this).css("border","2px solid red");
	});
	//3.移动movebox
	$(".bl-t ul").mousemove(function(e){
		//文档的尺寸-Ul距离文档边缘的尺寸-移动层一半的尺寸
		var X = e.pageX-$(this).offset().left-$('.movebox').width()/2;
		var Y = e.pageY-$(this).offset().top-$('.movebox').height()/2;
		if(X < 0 ){
			X = 0;
		}
		if(X > $(this).width() - $('.movebox').width()){
			X = $(this).width() - $('.movebox').width();
		}
		if(Y < 0 ){
			Y = 0;
		}
		if(Y > $(this).width() - $('.movebox').width()){
			Y = $(this).width() - $('.movebox').width();
		}
		$(".movebox").css("left", X + "px");
		$(".movebox").css("top", Y + "px");

		//3.1.设置放大层的默认放大的宽度和高度
		//获取默认放大倍数
		var n = $(".br ul").width()/$(".movebox").width();
		//3.1.1获取设置后的放大倍数
		var custom_n = $(".multiple").html();
		//3.2给放大的图片和图层设置宽度和高度
		$(".br ul li img").css("width", (custom_n*n*450) + "px");
		//3.3给放大的图层设置top和left
		$(".br ul li img").css("marginTop", -(custom_n*n*Y) +"px");
		$(".br ul li img").css("marginLeft", -(custom_n*n*X) +"px");
	});
	//4.movebox和放大层br的出现和隐藏
	$(".bl-t ul").hover(function(){
		$(".movebox").css("display", "block");
		$(".br ul").css("display", "block");
	},function(){
		$(".movebox").css("display", "none");
		$(".br ul").css("display", "none");
	});

	


});
