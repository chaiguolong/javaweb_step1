window.onload = function(){

	var aUl = document.getElementsByTagName("ul");

	var aLi = document.getElementsByTagName("li");

	var oImg = document.getElementById("img");

	var i=0;

	//正转和反转的标志
	var flag = true;

	//准备展示图片数据
	var arr = ['../images/024_lianyiqun.jpg','../images/024_xuefang.jpg','../images/024_Txu.jpg','../images/024_qianbiku.jpg','../images/024_hunsha.jpg','../images/024_waitao.jpg','../images/024_liantiku.jpg','../images/024_baobao.jpg','../images/024_liangxie.jpg','../images/024_danxie.jpg','../images/024_taiyangjing.jpg','../images/024_siwa.jpg','../images/024_fanbuxie.jpg','../images/024_qinglvzhuang.jpg'];

	var timer1 = null;

	var timer2 = null;

	//移入img和移除img的操作,移入则所有定时器都停止,移出则根据标识进行定时任务
	oImg.onmouseover = function(){
		window.clearInterval(timer1);
		window.clearInterval(timer2);
	}
	oImg.onmouseout = function(){

		if(flag == true){
			timer1 = window.setInterval(autoRunOne,500);
		}else if(flag == false){
			timer2 = window.setInterval(autoRunTwo,500);
		}
	}



	//移入Li和移除Li的操作
	for (var j = 0, len = aLi.length; j < len; j++) {
		//建立索引
		aLi[j].index = j;
		aLi[j].onmouseover = function(){
			window.clearInterval(timer1);
			window.clearInterval(timer2);

			for (var k = 0, len = aLi.length; k < len; k++) {
				aLi[k].style.background = "#fff";
				aLi[k].children[0].style.color = "#000";
			}

			//将当前索引赋值+1给i,从而从当前选中的下一项进行自动运行
			i = this.index + 1;

			this.style.background = "url(../images/024_bg.png) repeat-x";
			this.children[0].style.color = "#fff";
			oImg.src = arr[this.index];
		}

		aLi[j].onmouseout = function(){
			// for (var k = 0, len = aLi.length; k < len; k++) {
			// 	aLi[k].style.background = "#fff";
			// 	aLi[k].children[0].style.color = "#000";
			// }

			if(flag == true){
				timer1 = window.setInterval(autoRunOne,500);
			}else if(flag == false){
				timer2 = window.setInterval(autoRunTwo,500);
			}

		}
	}



	

	//自动开始跑
	timer1 = window.setInterval(autoRunOne,500);

	
	function autoRunOne(){
		// window.clearInterval(timer2);
		if(i < 0 ){
			i=0;
		}
		//清空之前的样式
		if(i != 0){
			aLi[i-1].style.background = "#fff";
			aLi[i-1].children[0].style.color = "#000";
		}

		//添加新样式
		aLi[i].style.background = "url(../images/024_bg.png) repeat-x";
		aLi[i].children[0].style.color = "#fff";
		oImg.src = arr[i];

		i++;
		if(i == aLi.length){
			window.clearInterval(timer1);
			timer2 = window.setInterval(autoRunTwo,500);
			//逆向运行,flag = false;
			flag = false;
		}
	}

	function autoRunTwo(){
		i--;
		//清空之前的样式
		if(i != aLi.length){
			aLi[i].style.background = "#fff";
			aLi[i].children[0].style.color = "#000";
		}

		//添加新样式
		aLi[i-1].style.background = "url(../images/024_bg.png) repeat-x";
		aLi[i-1].children[0].style.color = "#fff";
		oImg.src = arr[i-1];

		if(i == 1){
			window.clearInterval(timer2);
			timer1 = window.setInterval(autoRunOne,500);
			//正向运行,flag为true;
			flag = true;
		}
	}
}
