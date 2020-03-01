window.onload = function(){
	var oInfo01 = document.getElementById("info01");

	var aLi = oInfo01.getElementsByTagName("li");

	var oLeft = document.getElementsByClassName("btnL")[0];

	var oRight = document.getElementsByClassName("btnR")[0];

	var aCicle = document.getElementsByClassName("cicle");

	var aTabs = document.getElementById("tab").getElementsByTagName("a");

	var tab01 = document.getElementById("tab01");

	var tab02 = document.getElementById("tab02");

	var aContent = document.getElementsByClassName("content");

	var count = 0;

	var target = 0;

	for (var i = 0, len = aTabs.length; i < len; i++) {

		switchTab(aTabs[i]);
	}


	//切换tab
	function switchTab(tab){

		tab.onmouseover = function(){

			//全部恢复默认样式
			for (var i = 0, len = aTabs.length; i < len; i++) {
				aTabs[i].style.zIndex = "10";
				aTabs[i].style.color = "#086ba5";
				aTabs[i].children[0].src = "../images/031_tabPic_001.png";
				aTabs[i].children[1].classList.add("hidden");
				aContent[i].classList.add("hidden");
			}

			//对当前的元素进行操作
			tab.style.zIndex = "11";
			tab.children[0].src = "../images/031_tabPic_002.png";
			tab.children[1].classList.remove("hidden");
			tab.children[1].classList.add("show");
			tab.style.color = "#087b00";

			var index = this.getAttribute("id").split("tab0")[1];
			aContent[index-1].classList.remove("hidden");
			aContent[index-1].classList.add("show");
		}
	}

	oRight.onclick = function(){

		preventEventOfTime(this,800);

		target += -504;

		if(target <= -1008){
			target = -1008;
		}

		doMove(oInfo01,"marginLeft",-30,target,30,moveActive);

	}

	oLeft.onclick = function(){
		preventEventOfTime(this,800);

		target += 504;

		if(target >= 0){
			target = 0;
		}

		doMove(oInfo01,"marginLeft",30,target,30,moveActive);
	}

	function moveActive(oDiv,dir){

		//延迟30ms,这样获得的currentPos不会为运动中的值
		window.setTimeout(function(){

			//获取当前marginLeft值
			var currentPos = Number( window.getComputedStyle(oDiv,null)[dir].split("px")[0]);

			var index = Math.abs(currentPos)/ (504);

			for (var i = 0, len = aCicle.length; i < len; i++) {
				aCicle[i].classList.remove("active");
			}

			aCicle[index].classList.add("active");

		},30);


	}


	function doMove(oDiv,dir,speed,target,time,fn){
		var currentPos = Number( window.getComputedStyle(oDiv,null)[dir].split("px")[0]);

		oDiv.timer = window.setInterval(function(){
			currentPos += speed;

			if(speed <0 && currentPos <= target){
				currentPos = target;
				window.clearInterval(oDiv.timer);
				//如果回调函数存在,那么执行回调函数
				fn(oDiv,dir);
			}

			if(speed >0 && currentPos >= target){
				currentPos = target;
				window.clearInterval(oDiv.timer);
				fn(oDiv,dir);
			}

			oInfo01.style.marginLeft = currentPos + "px";

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
		},time);


	}
}
