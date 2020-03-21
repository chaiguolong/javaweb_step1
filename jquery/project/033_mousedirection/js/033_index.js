$(function(){
	$("#box").mouseenter(function(e){
		var w = $(this).width();
		var h = $(this).height();
		var left = $(this).offset().left;
		var top = $(this).offset().top;
		var scrollLeft = $(this).scrollLeft();
		var scrollTop = $(this).scrollTop();

		var ex = e.pageX;
		var ey = e.pageY;

		var ex = e.pageX - scrollLeft;
		var ey = e.pageY - scrollTop;

		var x=(ex-left-w/2)*(w>h?(h/w):1);
		var y=(ey-top-h/2)*(h>w?(w/h):1);

		var angle = (Math.round((Math.atan2(y,x) * 180/Math.PI + 180)/90) + 3) % 4;
		switch (angle) {
			case 0:
				$(this).css("background", "pink");
				break;
			
			case 1:
				$(this).css("background", "skyblue");
				break;
			case 2:
				$(this).css("background", "orange");
				break;
			case 3:
				$(this).css("background", "green");
				break;
		}
	});
});
