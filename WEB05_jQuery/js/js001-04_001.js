$(function(){
	//1.书写显示广告图片的定时操作
	time = setInterval("showAd()",3000);
});

//2.书写显示广告图片的函数
function showAd(){
	//3.获取广告图片，并让其显示
	$("#img2").fadeIn(4000);
	//4.清除显示图片定时操作
	clearInterval(time);
	//5.设置隐藏图片的定时操作
	time = setInterval("hiddenAd()",3000);
}

function hiddenAd(){
	//6.获取广告图片，并让其隐藏
	$("#img2").fadeOut(6000);
	//7.清除隐藏图片的定时操作
	clearInterval(time);
}

