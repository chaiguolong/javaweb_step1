window.onload = function(){
	//1.获取元素
	var aRight = document.getElementsByClassName("right");
	var aLeft = document.getElementsByClassName("left");
	var oLi = document.getElementsByTagName("li");
	var oUl = document.getElementsByTagName("ul");
	var oCircle = document.getElementById("circle");
	var oOrder = document.getElementById("order");
	var oPara = document.getElementById("para");

	//在全局先定义状态,默认为0,用于两个方法共享
	var status = 0;

	var flag = false;
	//绑定不同按钮设置不同的flag值
	oCircle.onclick = function(){
		flag = true;
		oPara.innerHTML = "图片可以从最后一张跳转到第一张循环切换";
	}
	oOrder.onclick = function(){
		flag = false;
		oPara.innerHTML = "图片只能到最后一张或第一张切换";
	}
	
	//2.给元素绑定方法
	//2.1向右移动图片
	function changeImgRight(){
		aRight[0].onclick = function(){
			//通过marginLeft值计算状态值(marginLeft为400px的倍数)
			var MR = oUl[0].style.marginLeft.split("px");
			status =Math.floor(Math.abs(MR[0]/400));
			if(status == 3 && flag == false){
				alert("已经是最后一张了");
			}else if(status == 3 && flag == true){
				oUl[0].style.marginLeft = "0px";
			}else{
				status++;
				oUl[0].style.marginLeft = "-" + 437*status+ "px";
			}
		}
	}

	//2.2向左移动图片
	function changeImgLeft(){
		aLeft[0].onclick = function(){
			//通过marginLeft值计算状态值(marginLeft为400px的倍数)
			var MR = oUl[0].style.marginLeft.split("px");
			status =Math.floor(Math.abs(MR[0]/400));
			if(status == 0 && flag == false){
				alert("已经是第一张了");
			}else if(status == 0 && flag == true){
				oUl[0].style.marginLeft =  "-" + 437*3 + "px";
			}else{
				status--;
				oUl[0].style.marginLeft =  "-" + 437*status + "px";
			}
		}
	}

	//3.运行方法
	changeImgRight();
	changeImgLeft();

}












	// function changImgRight(){
	// 	var count = 1;
	// 	var flag = true;
	// 	aRight[0].onclick = function(){
	// 		if(count == 4){
	// 			alert("已经是最后一张了");
	// 		}else{
	// 			oUl[0].style.marginLeft = "-" +437*count + "px";
	// 			count++;
	// 		}
	// 	}
    //
	// 	aLeft[0].onclick = function(){
	// 		if(count == 1){
	// 			alert("已经是最后一张了");
	// 		}else{
	// 			oUl[0].style.marginRight =  437*count + "px";
	// 			count--;
	// 		}
	// 	}
	// }
