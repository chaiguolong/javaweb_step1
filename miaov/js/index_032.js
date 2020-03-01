window.onload = function(){
	var oUl = document.getElementById("shopping");

	var aLi = oUl.getElementsByTagName("li");

	var aList_price = document.getElementsByClassName("list_price");

	var aList_hideImg = document.getElementsByClassName("hiddenImg");

	var aA = oUl.getElementsByTagName("a");

	var oTotal = document.getElementById("total");

	var oPrice = oTotal.getElementsByClassName("red")[0];

	var timer1 = null;

	//商品列表总价格

	var total_price = 0;

	//设置商品布局
	for (var i = 0, len = aLi.length; i < len; i++) {
		aLi[i].style.left = 163 * i +"px";
		aLi[i].style.top = "0px";
	}



	for (var i = 0, len = aLi.length; i < len; i++) {

		aLi[i].index = i;

		aA[i].onclick = function(){
			//清除之前的定时器
			window.clearInterval(this.timer1);
			//获取将来时间
			var oNew = new Date(aLi[this.parentElement.index].children[0].value);

			var _this = this;

			_this.timer1 = window.setInterval(function(){
				//获取当前时间
				var oNow = new Date();

				//获取将来时间与现在时间的秒值差,并向下取整
				var countDown = Math.floor((oNew.getTime() - oNow.getTime())/1000);

				if(countDown <= 0){
					window.clearInterval(_this.timer1);
					shake(_this.parentElement,backRun);
				}

				var str_second = toTwo(countDown%60);

				var str_min = toTwo(Math.floor(countDown/60%60));

				var str_hour = toTwo(Math.floor(countDown/3600%24));

				var str_day = Math.floor(countDown/3600/24);

				var str = "还剩"+str_day +"天"+str_hour+"小时"+str_min+"分"+str_second+"秒";

				aLi[_this.parentElement.index].children[2].innerHTML = str;

			},1000);


		}
	}

	//抖动函数
	function shake(ele,fn){

		var arr_shake = [-15,15,-13,13,-11,11,-9,9,-7,7,-5,5,-3,3,-1,1,0];

		//arr_shake 的索引
		var index = 0;

		var currentPos = Number(ele.style.left.split("px")[0]);

		ele.timer1 = window.setInterval(function(){

			currentPos += arr_shake[index];

			ele.style.left = currentPos + "px";

			if(index >= arr_shake.length ){
				index = arr_shake.length;
				window.clearInterval(ele.timer1);

				//如果有回调函数,则运行回调函数,否则空
				fn?fn(ele):'';
			}
			index++;
			
		},30);

	}

	//回调函数
	function backRun(ele){

		doMove(ele,6,"top",200,30);
		opacity(ele,0.05,0,50);
		showGoodsList(ele);


	}

	//显示商品列表
	function showGoodsList(ele){
		window.setTimeout(function(){
			//1.显示商品列表
			var list_price = aList_price[ele.index];
			list_price.style.display = "block";
			// 2.计算商品价格
			var	price = Number(list_price.children[1].innerText);

			total_price += price;

			oPrice.innerHTML = total_price;
		   
		},800);

	}


	//往下移动
	function doMove(oDiv,speed,dir,target,time){

		var currentPos = Number(window.getComputedStyle(oDiv,null)[dir].split("px")[0]);

		oDiv.timer = window.setInterval(function(){
			currentPos += speed;

			if(speed <0 && currentPos <= target){
				currentPos = target;
				window.clearInterval(oDiv.timer);
			}

			if(speed >0 && currentPos >= target){
				currentPos = target;
				window.clearInterval(oDiv.timer);
			}

			oDiv.style[dir] = currentPos + "px";

		},time);

	}


	//减少透明度
	function opacity(oDiv,speed,target,time){

		var opaIndex = 1;
		//蓝条透明度按照0.05的速度降低
		//必须把定时器绑定到oDiv元素上,不然多个元素调用同一个定时器,会导致定时器混乱
		oDiv.timer2 = window.setInterval(function(){
			opaIndex -= speed;

			if(window.parseFloat(opaIndex) <= target){
				opaIndex = target;
				window.clearInterval(oDiv.timer2);
			}

			oDiv.style.opacity = opaIndex +"";

		},time);
	}



	//将小于10的字符串转为2位数
	function toTwo(str){

		return window.parseInt(str) >= 10 ?str : "0" + str;
	}






}
