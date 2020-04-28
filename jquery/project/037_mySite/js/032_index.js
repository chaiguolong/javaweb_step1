$(function(){
	$("ul li").on("mouseenter", function(e){
		var angle = calcAngle(e,this);
		mouseEvent(angle, this, "in");
	});

	$("ul li").on("mouseleave", function(e){
		var angle = calcAngle(e,this);
		mouseEvent(angle, this, "out");
	});

	function mouseEvent(angle,o,action){
		var w = $(o).width();
		var h = $(o).height();
		if(action == "in"){
			switch (angle) {
				case 0:
					//初始化p元素的位置为上面
					$(o).find("p").css({"top":-h+"px","left":"0px","display":"block"}).stop().animate({"top": 0 +"px"},300);
					break;
				case 1:
					$(o).find("p").css({"top": "0px","left":w+"px","display":"block"}).stop().animate({"left": 0 +"px"},300);
					break;
				case 2:
					$(o).find("p").css({"top":h+"px","left":"0px","display":"block"}).stop().animate({"top": 0 +"px"},300);
					break;
				case 3:
					$(o).find("p").css({"top": "0px","left":-w+"px","display":"block"}).stop().animate({"left": 0 +"px"},300);
					break;
			}
		}

		if(action == "out"){
			switch (angle) {
				case 0:
					$(o).find("p").stop().animate({"top": -h +"px"},300);
					break;
				case 1:
					$(o).find("p").stop().animate({"left": w +"px"},300);
					break;
				case 2:
					$(o).find("p").stop().animate({"top": h +"px"},300);
					break;
				case 3:
					$(o).find("p").stop().animate({"left": -w +"px"},300);
					break;
			}
		}
	}

	function calcAngle(e,o){
		//获取盒子的宽和高,一句偏移量
		var w = $(o).width();
		var h = $(o).height();

		var offsetTop = $(o).offset().top;
		var offsetLeft = $(o).offset().left;

		//获取scroll量
		var scrollTop = $(o).scrollLeft();
		var scrollLeft = $(o).scrollTop();
		//以矩形为中心原点的任意点的坐标(x,y)的坐标
		//ex,ey坐标为去除scroll之后的坐标
		var ex = e.pageX - scrollLeft;
		var ey = e.pageY- scrollTop;
		//将矩形的坐标映射为正方形的坐标
		var x = (ex - offsetLeft - w/2) * (w > h ? (h/w) : 1);
		var y = (ey - offsetTop - h/2) * (h > w ? (w/h) : 1);

		//计算坐标(x,y)所对应的角度
		var angle = (Math.round((Math.atan2(y,x)*180/Math.PI + 180) / 90) + 3) % 4;
		return angle;
}
});
