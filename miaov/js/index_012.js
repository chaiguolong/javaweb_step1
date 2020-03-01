window.onload = function(){
	var arrPic = ["../images/012_mianbao1.jpg","../images/012_mianbao2.jpg","../images/012_mianbao3.jpg","../images/012_mianbao4.jpg"];

	var aLeft = document.getElementsByClassName("left");

	var aRight = document.getElementsByClassName("right");

	var oU = document.getElementsByTagName("ul");

	var aLi = oU[0].getElementsByTagName("li");

	var oImg = document.getElementById("pic");

	var oLiAct = document.getElementsByClassName("active");

	var num = 0;


	//1.向右点击
	aRight[0].onclick = function(){
		//1.1获取oLiAct所在的index值
		num = oLiAct[0].index;
		num++;
		//1.2.先进行判断,当索引大于arrPic的时候,将num赋值为arrPic.leng-1
		if(num >= (arrPic.length -1)){
			num = arrPic.length -1;
		}
		//1.3.将oImg的src换为数组的路径
		oImg.src = arrPic[num];
		//1.4.将所有Li的active置空
		for (var i = 0, len = aLi.length; i < len; i++) {
			aLi[i].setAttribute("class","");
		}
		//1.5将第num个Li设置为选中
		aLi[num].setAttribute("class","active");
	}

	//2.向左点击
	aLeft[0].onclick = function(){
		//1.1获取oLiAct所在的index值
		num = oLiAct[0].index;
		num--;
		//2.2如果num <=0,将num赋值为0;
		if(num <= 0){
			num = 0;
		}
		//2.3.将oImg的src换为数组的路径
		oImg.src = arrPic[num];
		//2.4.将所有Li的active置空
		for (var i = 0, len = aLi.length; i < len; i++) {
			aLi[i].setAttribute("class","");
		}
		//2.5将第num个Li设置为选中
		aLi[num].setAttribute("class","active");
	}


	//3.移入指定的li,显示相应的图片缩略图
	//3.1循环遍历每个LI,绑定onmouseover和onmouseout
	for (var i = 0, len = aLi.length; i < len; i++) {
		//为每个Li绑定一个自定义属性index
		aLi[i].index = i;

		aLi[i].onmouseover = function(){
			//3.2构造字符串
			var simpleStr = '';
			simpleStr += '<div class="suolue">';
			simpleStr += '<img  id="img1"src="../images/012_mianbao'+(this.index+1)+'.jpg" width="80px" height="50px"/>';
			simpleStr += '<img id="img2" src="../images/012_xiajiantou.png" alt=""/>';
			simpleStr += '</div>';

			//清除上一个的active
			// oLiAct[0].setAttribute("class","");
			this.innerHTML = simpleStr;
			// this.setAttribute("class","active");
		}

		aLi[i].onmouseout = function(){
			this.innerHTML = "";
		}

		//4.单击缩略图跳转到相应的图片
		aLi[i].onclick = function(){
			oImg.src = arrPic[this.index];
			//清除上一个的active
			oLiAct[0].setAttribute("class","");
			this.setAttribute("class","active");

		}
	}


	

	
}
