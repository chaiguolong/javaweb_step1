$(function(){
	//1.设置定时显示图片时间
	time = setInterval("showAd()",3000);
});

function showAd(){
	//2.获取图片元素,显示图片
	$("#img2").fadeIn(3000);
	//3.清除定时显示图片时间
	clearInterval(time);
	//4.设置定时隐藏图片时间
	time = setInterval("hiddenAd()",3000);
}

function hiddenAd(){
	//5.获取图片元素,隐藏图片
	$("#img2").fadeOut(6000);
	//6.清除定时隐藏图片的时间
	clearInterval(time);
}
