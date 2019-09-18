window.onload = function(){

	var oUl = document.getElementById("con");

	var oColor = document.getElementById("color");

	var aLi = oUl.getElementsByTagName("li");

	var timer1 = null;

	var timer2 = null;

	//设置默认的布局
	defaultSet();

	oUl.onclick = function(){

		//再次点击之前清除原先的定时器
		window.clearInterval(timer1);
		window.clearInterval(timer2);

		//初始化每次点击之前的数据
		var topIndex = 0;

		//文字从下往上
		//给每个span都设定一个计时器
		aLi[topIndex].timer3 = window.setInterval(function(){
			doMove(aLi[topIndex],"top",-2,-120,7);
			opacity(aLi[topIndex],0.05,0,20);
			topIndex++;
			if(topIndex == aLi.length){
				topIndex = 0;
				window.clearInterval(aLi[topIndex].timer3);
			}
		},135);


		// 蓝条从左到右移动
		timer1 = window.setInterval(function(){
		//oColor的当前宽度
		var currentWidth =window.parseInt(window.getComputedStyle(oColor,null).width);

			currentWidth += 10;

			if(currentWidth >= 499){
				currentWidth = 500;
				window.clearInterval(timer1);
			}

			oColor.style.width = currentWidth + "px";

		},10);

		opacity(oColor,0.02,0,50);

		
		//阻止点击事件,2s钟之后激活
		preventEventOfTime(this,2500);
	}

	//减少透明度
	function opacity(oDiv,speed,target,time){

		var opaIndex = 1;

		//蓝条透明度按照0.05的速度降低
		//必须把定时器绑定到oDiv元素上,不然多个元素调用同一个定时器,会导致定时器混乱
		oDiv.timer2 = window.setInterval(function(){
			opaIndex -= speed;

			oDiv.style.opacity = opaIndex +"";

			console.log("--------"+opaIndex+"-----------");

			if(window.parseFloat(opaIndex) <= target){
				opaIndex = 1;
				window.clearInterval(oDiv.timer2);
			}

		},time);
	}

	function doMove(oDiv,dir,speed,target,time){
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

		},time);

	}


	//_this需要阻止事件的元素,time需要阻止的时间长度
	function preventEventOfTime(_this,time){
		//点击之后将该元素的点击事件阻止,避免在计时器运行期间再次点击
		var that = _this;

		that.style.pointerEvents = "none";

		window.setTimeout(function(){
			//一秒钟之后将点击事件激活
			that.style.pointerEvents = "auto";
			//恢复默认的设置

			for (var j = 0, lenj = aLi.length; j < lenj; j++) {
				aLi[j].style.opacity = 1;
				aLi[j].style.left = 50*j + "px";
				aLi[j].style.top = "0px";
			}
			//颜色层显示
			oColor.style.opacity = 1;
			oColor.style.width = "0px";
			oColor.style.backgroundColor = "#4aa";
		},time);

	}


	function defaultSet(){
		for (var i = 0, len = aLi.length; i < len; i++) {
			aLi[i].style.opacity = 1;
			aLi[i].style.left = 50*i + "px";
			aLi[i].style.top = "0px";
		}
	}

}
