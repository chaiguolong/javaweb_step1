$(function(){
	//1.设置显示广告时间
	time = setInterval("showAd()",3000);
});

function showAd(){
	//3.获取广告图片，并让其显示
	$("#img2").fadeIn(6000);
	//4.清除显示图片定时操作
	clearInterval(time);
	//5.设置隐藏图片的定时操作
	time = setInterval("hiddenAd()",3000);
}

function hiddenAd(){
	$("#img2").fadeOut(6000);
	clearInterval(time);
}
