$(function(){
	/*
	 *	思路:
	 *		1.点击>图标
	 *		2.获取当前page,将page+1
	 *			2.1.初始化开始page为1;
	 *		3.先全部移去active类
	 *		4.开始运动,添加(移去)固定元素active类
	 */

	//2.1.初始化开始page为1;
	var page = 1;
	var len = $('.page').length;

	//1.点击图标
	$(".scrollRight").click(function(){
		if(page >= len){
			return;
		}
		if(page == 1){
			$('.page-1 .left').css({"transform":"translateX(-100%)"});
			$('.page-1 .right').css({"transform":"translateX(100%)"});
		}
		//2.获取当前page,将page+1
		page++;
		//3.先移去全部的active类
		$(".page").each(function(){
			$(this).removeClass("active");
		});
		//4.开始运动,添加(移去)固定的active类
		$(".page-"+page).addClass("active");
	});

	//1.点击图标
	$(".scrollLeft").click(function(){
		if(page <= 1){
			return;
		}
		//2.获取当前page,将page-1
		page--;
		//3.先移去全部的active类
		$(".page").each(function(){
			$(this).removeClass("active");
		});
		//4.开始运动,添加(移去)固定的active类
		$(".page-"+page).addClass("active");
	});

});
