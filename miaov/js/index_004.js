window.onload = function(){
	var oImg = document.getElementById('img01');
	var oInput = document.getElementById("input01");
	var oSpan = document.getElementById("span01");
	var oTop = document.getElementById("top");



	// 切换角色
	var count = 0;
	function changeImg(){
		if(count % 2 == 0){
			oImg.src="../images/004_dabing.png";
		}else{
			oImg.src="../images/004_tuhao.png";
		}
		count ++;
	};

	oImg.onclick = changeImg;

	// 发送文字
	//	  <div class="mess">
	//		<p>
	//		</p>
	//	  </div>
	function sendMessage(){
		//构建布局
		//1.增加中间信息栏
		var eDivContent = document.createElement("div");
		//2增加mess类属性
		eDivContent.setAttribute("class","mess");
		//3.增加内容栏p标签
		var ePaContent = document.createElement("p");
		//4.添加到中间内容栏p标签
		eDivContent.appendChild(ePaContent);
		//5.将中间内容栏添加到oTop元素下
		oTop.appendChild(eDivContent);

		//6.判断角色,添加内容,如果点击次数是偶数,添加土豪信息
		if(count % 2 == 0){
			//1.获取土豪角色
			var sRole = oImg.src;
			//2.获取土豪内容
			var sContent = "说:"+oInput.value;
			//3.将土豪内容添加到中间内容栏
			ePaContent.append(sContent);
			//4.将土豪角色添加到中间内容栏背景
			ePaContent.style.background = "url("+sRole+") no-repeat top left";
			ePaContent.style.textAlign = "left";
			ePaContent.style.paddingLeft ="26px";
		//7.如果点击次数是奇数,添加大兵信息
		}else{
			//1.获取大兵角色
			var sRole = oImg.src;
			//2.获取大兵内容
			var sContent = "说:"+oInput.value;
			//3.将大兵内容添加到中间内容栏
			ePaContent.append(sContent);
			//4.将土豪角色添加到中间内容栏背景
			ePaContent.style.background = "url("+sRole+") no-repeat top right";
			ePaContent.style.textAlign = "right";
			ePaContent.style.paddingRight ="26px";
		}
		oInput.value = "";
	}

	oSpan.onclick = sendMessage;
}
