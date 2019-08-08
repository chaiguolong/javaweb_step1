window.onload = function(){

	var aA = document.getElementsByTagName("a");

	var oStar = document.getElementById("star");

	var oTishi = document.getElementById("tishi");

	var aImg = document.getElementsByTagName("img");

	var oWenzi = document.getElementById("wenzi");

	//图片移动星星的数量
	var count = 0;

	//图片移动的像素数
	var oldScreenX = 0;

	/*
	 * -125         0
	 * -100		   1
	 * -75		   2
	 * -50		   3
	 * -25		   4
	 * 0		   5
	 */

	aImg[0].onmousemove = function(event){

		oTishi.style.display = "none";

		var screenX = oldScreenX + event.offsetX;
		//解决screeX相加导致screenX超过250px的情况,优化screenX为0的情况
		if(screenX > 250){
			screenX = 250;
		}

		count = Math.ceil((screenX-125)  / 25);

		switch (count) {
			case 1:
				oWenzi.innerHTML = "很差";
				break;
			case 2:
				oWenzi.innerHTML = "较差";
				break;
			case 3:
				oWenzi.innerHTML = "还行";
				break;
			case 4:
				oWenzi.innerHTML = "推荐";
				break;
			case 5:
				oWenzi.innerHTML = "力荐";
				break;
			
			default:
				oWenzi.innerHTML = "";
				
		}

		if(screenX <= 175){
			this.src = "../images/021_pingfen01.png";
		}else{
			this.src = "../images/021_pingfen.png";
		}
			this.style.marginLeft = -125 + (count*25) + "px";

		oldScreenX = count*25;
	}

	aImg[0].onmouseout = function(){
		this.style.marginLeft = "-125px";
		oTishi.style.display = "block";
		oWenzi.innerHTML = "";
	}


}

