function init(){
	//书写轮图片显示的定时操作
	setInterval("changeImg()",3000);
}

//书写函数
var i=0
function changeImg(){
	i++;
	//获取图片位置并设置src属性值
	document.getElementById("img1").src="../img/"+i+".jpg";
	if(i==3){
		i=0;
	}
}
