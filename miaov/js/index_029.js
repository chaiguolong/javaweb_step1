window.onload = function(){

	var oUl = document.getElementById("con");

	var aLi = oUl.getElementsByTagName("li");

	var aSpan = [];

	var timer1 = null;

	var timer2 = null;

	var opaIndex = 1;

	for (var i = 0, len = aLi.length; i < len; i++) {
		aLi[i].style.left = 50*i + "px";

		aLi[i].children[0].style.top = "0px";

		//将span都添加到aSpan数组中
		aSpan.push(aLi[i].children[0]);
	}

	oUl.onclick = function(){

		//阻止点击事件,2s钟之后激活
		preventEventOfTime(this,2000);

		//再次点击之前清除原先的定时器
		window.clearInterval(timer1);
		window.clearInterval(timer2);

		//初始化每次点击之前的数据
		var	index = 0;

		var topIndex = 0;

		opaIndex = 1;

		//文字从下往上
		//给每个span都设定一个计时器
		aSpan[topIndex].timer3 = window.setInterval(function(){
			doMove(aSpan[topIndex],"top",-20,-120);
			topIndex++;
			if(topIndex == aSpan.length){
				topIndex = 0;
				window.clearInterval(aSpan[topIndex].timer3);
			}
		},100);


		// 蓝条从左到右移动
		timer1 = window.setInterval(function(){
			aLi[index].style.background = "#4aa";
			index++;
			//如果index大于等于aLi.length的长度,则定时器停止
			if(index >= aLi.length){
				index = aLi.length-1;
				window.clearInterval(timer1);
				//在定时器timer2关闭之后,延时1s,显示默认的Li样式
				window.setTimeout(function(){
					for (var i = 0, len = index; i <= len; i++) {
						aLi[i].style.background = "#fff";
						aLi[i].children[0].style.opacity = "1";
						aLi[i].style.opacity = "1";
						aLi[i].children[0].style.top = "0px";
					}
				},800);
			}
		},100);

		timer2 = window.setInterval(function(){
			opaIndex -= 0.05;

			for (var i = 0, len = index; i <= len; i++) {
				aLi[i].style.opacity = opaIndex +"";
				aLi[i].children[0].style.opacity = opaIndex +"";
			}

			if(opaIndex <= 0.1){
				opaIndex = 1;
				window.clearInterval(timer2);
			}

		},80);
	}

	function doMove(oDiv,dir,speed,target){
		oDiv.timer1 = window.setInterval(function(){

			var currentDir = window.parseInt(window.getComputedStyle(oDiv,null)[dir]) + speed;

			if(speed > 0 && currentDir >= target){
				currentDir = target;
				window.clearInterval(oDiv.timer1);
			}

			if(speed < 0 && currentDir <= target){
				currentDir = target;
				window.clearInterval(oDiv.timer1);
			}

			var nextDir = currentDir  + "px";

			oDiv.style[dir] = nextDir;

		},100);

	}


	//_this需要阻止事件的元素,time需要阻止的时间长度
	function preventEventOfTime(_this,time){
		//点击之后将该元素的点击事件阻止,避免在计时器运行期间再次点击
		var that = _this;

		that.style.pointerEvents = "none";

		window.setTimeout(function(){
			//一秒钟之后将点击事件激活
			that.style.pointerEvents = "auto";
		},time);

	}

}
