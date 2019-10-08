window.onload = function(){

	var oUl = document.getElementById("ul_clock");

	var aLi = oUl.getElementsByTagName("li");

	var aImg = document.getElementsByTagName("img");

	var aLi_clock = oUl.getElementsByClassName("clock");

	var oContainer = document.getElementById("container");

	var str = '';

	//初始化Li
	for (var i = 0, len = 8; i < len; i++) {
		str += '<li class="clock" style="left: '+50*i+'px"> <img id="img01" style="top: 0px" src="../images/033_000.jpg" alt="click"/>'
			+'<img id="img02" style="top: 70px;"src="../images/033_000.jpg" alt="click"/></li>';
		oUl.innerHTML = str;
	}

	//替换图片:
	changePic();
	//先执行一次
	countDown(0,0);
	//冒号:闪动
	colonFlash();
	//定一个计时器,每一秒都在运动
	window.setInterval(function(){
		// var oSecond = aLi_clock[aLi_clock.length -1];
		//上面的时钟
		countDown(0,0);
		countDown(1,1);
		for (var i = 0, len = aLi_clock.length; i < len; i++) {
			//获取src路径,当上下数字不一样的时候,运行clockMove函数
			var num1  = aLi_clock[i].children[0].src.split("_")[1];
			var num2  = aLi_clock[i].children[1].src.split("_")[1];
			if(num1 != num2){
				clockMove(aLi_clock[i]);
			}
		}

	},1000);


	function colonFlash(){
		//冒号:切换的标志位
		var flag = true;
		window.setInterval(function(){
			if(flag == true){
				aLi[2].children[0].src = '../images/033_00b.jpg';
				aLi[5].children[0].src = '../images/033_00b.jpg';
				flag = false;
			}else{
				aLi[2].children[0].src = '../images/033_00c.jpg';
				aLi[5].children[0].src = '../images/033_00c.jpg';
				flag = true;
		}

		},500);


	}


	//将0图片替换为:
	function changePic(){
		aLi[2].children[0].src = '../images/033_00c.jpg';
		aLi[2].children[1].src = '../images/033_00b.jpg';
		aLi[2].classList.remove("clock");
		aLi[5].children[0].src = '../images/033_00c.jpg';
		aLi[5].children[1].src = '../images/033_00b.jpg';
		aLi[5].classList.remove("clock");

	}


	function clockMove(ele,fn){

		window.clearInterval(ele.timer1);

		var currentPos = Number(ele.children[0].style.top.split("px")[0]);

		ele.timer1 = window.setInterval(function(){

			currentPos += -4;

			if(currentPos <= -70){
				currentPos = -70;
				window.clearInterval(ele.timer1);
			}

			ele.style.top = currentPos + "px";

		},10);

	}

	//倒计时
	function countDown(index,delay){
		//当前时间
		var tNow = new Date();
		//将来时间
		var tNew = new Date('October 15 2019 00:00:00');
		//将来时间和现在时间之差的秒数
		var interval = Math.floor((tNew - tNow) / 1000) - delay;


		var str_second = toTwo(interval%60);

		var str_min = toTwo(Math.floor(interval/60%60));

		var str_hour = toTwo(Math.floor(interval/3600));

		//c------colon,b-------black;
		var str_colon = 'cb';

		//上面
		aLi[0].children[index].src = "../images/033_00"+str_hour.charAt(0)+".jpg";
		aLi[1].children[index].src = "../images/033_00"+str_hour.charAt(1)+".jpg";
		aLi[2].children[index].src = "../images/033_00"+str_colon.charAt(0)+".jpg";
		aLi[3].children[index].src = "../images/033_00"+str_min.charAt(0)+".jpg";
		aLi[4].children[index].src = "../images/033_00"+str_min.charAt(1)+".jpg";
		aLi[5].children[index].src = "../images/033_00"+str_colon.charAt(0)+".jpg";
		aLi[6].children[index].src = "../images/033_00"+str_second.charAt(0)+".jpg";
		aLi[7].children[index].src = "../images/033_00"+str_second.charAt(1)+".jpg";

		if(interval <= 0){
			window.clearInterval(timer1);
		}
	}


	//将小于10的字符串转为2位数
	function toTwo(str){

		return window.parseInt(str) >= 10 ?str+"" : "0" + str;
	}
}
