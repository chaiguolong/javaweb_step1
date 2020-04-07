$(function(){
	$('#demo1').flexImages({
		rowHeight: 140,     //设置每行图片的固定高度
		container:'.item',  //元素模块
		truncate: false     //默认设置即可
	});


	$(".item").hover(function(){
		var ind = $(this).index();
		ind++;
		$(this).find("a").append("<span class='span01'>"+ind+"</span>");
	},function(){
		//清除所有span01的span
		$(".span01").remove();
	});
});
