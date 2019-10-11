window.onload = function(){
	var oToRight = document.getElementById("toRight");

	var oText_area = document.getElementById("text_area");

	var oRight = document.getElementById("right");

	var oUl_middle = document.getElementById("ul_middle");

	var oUl = document.getElementById("move");

	var aLi = oUl.getElementsByTagName("li");

	var text_right = '';

	var timer1 = null;

	var timer2 = null;


	//点击文字向右移动
	oToRight.onclick = function(){

		console.log(oRight);

		oRight.innerHTML = "";

		window.clearInterval(timer1);
		window.clearInterval(timer2);
		this.style.backgroundColor = "#e7cece";
		calWord();
	}

	//跑马灯效果
	function moveLi(){
		var index_li = 0;
		timer2 = window.setInterval(function(){
			for (var i = 0, len = aLi.length; i < len; i++) {
				aLi[i].style.backgroundColor = "#e7a521";
			}
			aLi[index_li].style.backgroundColor = "#ef6363";
			index_li++;
			if(index_li == aLi.length){
				index_li = 0;
				// window.clearInterval(timer2);
			}
		},50);

	}



	//计算字数
	function calWord(){

		//用value才能获取输入的文本,用innerHTML只能获取在HTML中已经写好的固定文本
		var text_all = oText_area.value;

		var totalWord = text_all.length;

		var index = 0;

		moveLi();

		timer1 = window.setInterval(function(){
			//获取第一个文本
			var word = text_all.charAt(index);
			//用第一个文本截取整段文字,并获取数组第二个字符串
			var leftWord = text_all.substring(index+1,text_all.length);
			//剩下的文本数
			var leftCount = leftWord.length;
			//将剩下的文字赋值给原来的文本
			oText_area.value = leftWord;
			//将第一个文本移动到右边
			text_right += word;

			oRight.innerHTML = text_right;

			var count = totalWord - leftCount;

			oUl_middle.innerHTML = count+"/"+totalWord;

			index++;

			if(leftCount == 0){
				window.clearInterval(timer2);
				window.clearInterval(timer1);
				for (var i = 0, len = aLi.length; i < len; i++) {
					aLi[i].style.backgroundColor = "#e7a521";
				}
				oToRight.style.backgroundColor = "#f76300";
			}

		},50);


	}

	oToRight.onmouseover = function(){
		this.style.background = "#c63908";
	}
	oToRight.onmouseout = function(){
		this.style.background = "#f76300";
	}


}
