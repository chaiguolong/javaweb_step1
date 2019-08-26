window.onload = function(){

	var picArr = ['../images/026_001.jpg','../images/026_002.jpg','../images/026_003.jpg','../images/026_004.jpg','../images/026_005.jpg','../images/026_006.jpg'];

	var oMenu1 = document.getElementById("menu1");

	var oMenu2 = document.getElementById("menu2");
	
	var oCon3 = document.getElementById("con3");

	var aLi = oCon3.getElementsByTagName("li");

	var oImg = document.getElementById("img");

	var oMenu1 = document.getElementById("menu1");

	var oMenu2 = document.getElementById("menu2");

	var oContent1 = document.getElementById("content1");

	var oContent2 = document.getElementById("content2");

	/*
	 * 图片1------->图片2------>图片3----------->图片4--------->图片5------------->图片6(判断是否被3整除)
	 *
	 * 思路:
	 *	1.写一个方法(传递一个参数,即索引):选中Li,改变背景颜色和前景色,改变图片的地址,即改变数组的索引
	 *		2.1:选中菜单一,更改背景颜色和前景色
	 *		2.1:清除之前的样式
	 *		2.2:如果index == li的长度,则置为0,且切换到菜单一;
	 *			2.2.1:将index置为0,并切换到菜单一
	 *			2.2.2:改变菜单一的背景色和前景色
	 *		2.3:如果index能被3整除,则切换到菜单二
	 *	2.创建一个定时器,调用该方法
	 *
	 */

	var index = 0;

	function selectLi(){

		//2.1清除之前的样式

		if(index != 0){
			aLi[index-1].style.background = "#f7f7f7";
			aLi[index-1].style.color = "#000";

		}

		//2.2如果index == li的长度,则置为0,且切换到菜单一;
		if(index == 0 || index == aLi.length){

			//2.2.1将index置为0,并切换到菜单一
			index = 0;
			oContent1.style.display = "block";
			oContent2.style.display = "none";

			//2.2.2改变菜单一和二的背景色和前景色
			oMenu2.style.background = "#94ffc6";
			oMenu2.style.color = "#000";

			oMenu1.style.background = "#005a63";
			oMenu1.style.color = "#fff";
		}

		//2.3如果index能被3整除,则切换到菜单二
		if(index != 0 && index % 3 == 0 ){
			oContent1.style.display = "none";
			oContent2.style.display = "block";

			//2.3.2改变菜单一和二的背景色和前景色
			oMenu1.style.background = "#94ffc6";
			oMenu1.style.color = "#000";

			oMenu2.style.background = "#005a63";
			oMenu2.style.color = "#fff";
		}


		aLi[index].style.background = "#639cc6";
		aLi[index].style.color = "#fff";
		oImg.src = picArr[index];

		index++;
	}


	window.setInterval(selectLi,1000);

}
