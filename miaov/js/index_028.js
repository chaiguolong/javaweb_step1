window.onload = function(){
	var oUl = document.getElementsByTagName("ul");

	var aLi = oUl[0].getElementsByTagName("li");

	var index = 0;

	for (var i = 0, len = aLi.length; i < len; i++) {
		aLi[i].style.left = 110*i + "px";
		aLi[i].style.top = "150px";
		aLi[i].onmouseover = function(){

			var that = this;

			//将onmouseover屏蔽
			that.style.pointerEvents = "none";

			shake(this,"top");

			//设置1300ms后将onmouseover设置为自动
			window.setTimeout(function(){
				that.style.pointerEvents = "auto";
			},1300);
		}

	}


	/*
	 * 思路: 上下移动,不断减少top值,放入数组
	 *
	 */

	function shake(oLi,dir){

		var timer2 = null;

		//声明数组的索引
		var index = 0;

		//定义数组,存入需要抖动的target
		var array = [170,130,165,135,160,140,155,145,150];

		var speed = -10;


		//每次执行新的计时器之前清除原有的计时器
		window.clearInterval(timer2);

		//定义一个定时器,每隔50ms执行一次函数,达到数组中的target
		timer2 = window.setInterval(function(){

			//速度第一次要设置为-5,因为当前的top为150,如果要达到20,只能不断的减少top值,不能增加
			doMove(oLi,"top",speed,array[index]);

			//下一个数组数据
			index++;

			//将速度变为正数
			speed *= -1;

			//如果索引达到数组最后一个,则将定时器停止
			if(index == array.length){
				window.clearInterval(timer2);
			}

		},150);


	}


	function doMove(oDiv,dir,speed,target){

		//在新建定时器之前清空之前的定时器
		window.clearInterval(oDiv.timer1);

		//新建一个定时器
		oDiv.timer1 = window.setInterval(function(){

			//获得当前元素的位置值,且加上速度值,例如:top值+speed值
			var currentDir = window.parseInt(window.getComputedStyle(oDiv,null)[dir]) + speed;

			//如果当前的速度是大于0,以top为例:则为下降,且当前的top值大于目标值,则当前值等于目标值,且停止当前元素的计时器
			if(speed > 0 && currentDir >= target){
				currentDir = target;
				window.clearInterval(oDiv.timer1);
			}

			//如果当前的速度是小于0,以top为例:则为上升,,且当前的top值小于等于目标值,则当前值等于目标值,且停止当前元素的计时器
			if(speed < 0 && currentDir <= target){
				currentDir = target;
				window.clearInterval(oDiv.timer1);
			}

			//将需要的值转为像素值
			var nextDir = currentDir  + "px";

			//将像素值赋值给当前元素
			oDiv.style[dir] = nextDir;

		},20);


	}

}
