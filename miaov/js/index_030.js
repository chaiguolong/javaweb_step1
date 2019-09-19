window.onload = function(){
	var oUl = document.getElementById("oUl");
	
	var aLi = oUl.getElementsByTagName("li");

	var oCon = document.getElementById("container");

	var oExp = document.getElementById("exp");

	var oP = oExp.getElementsByTagName("p")[0];

	var oH3 = oExp.getElementsByTagName("h3")[0];

	//定时器索引
	var index = 0;

	// var wheel = 1;

	var timer1 = null;

	var timer2 = null;

	var timer3 = null;

	//存放Li的数组
	var aLiArr = [];

	//初始化数据
	var picArr = ['../images/030_001.jpg','../images/030_002.jpg','../images/030_003.jpg','../images/030_004.jpg','../images/030_005.jpg','../images/030_001.jpg','../images/030_002.jpg','../images/030_003.jpg','../images/030_004.jpg','../images/030_005.jpg'];
	var h3Arr = ['辣爸银幕成绩单','&lt;&lt;宫锁沉香&gt;&gt;可以免费看啦!','&lt;&lt;金蝉脱壳&gt;&gt;曝终极预告片 影片五大看点全揭秘','&lt;&lt;扫毒&gt;&gt;曝主题曲MV 刘青云古天乐张家辉反目','&lt;&lt;谁说我们不会爱&gt;&gt;杜淳意外走光 颖儿娇羞爆表','辣爸银幕成绩单','&lt;&lt;宫锁沉香&gt;&gt;可以免费看啦!','&lt;&lt;金蝉脱壳&gt;&gt;曝终极预告片 影片五大看点全揭秘','&lt;&lt;扫毒&gt;&gt;曝主题曲MV 刘青云古天乐张家辉反目','&lt;&lt;谁说我们不会爱&gt;&gt;杜淳意外走光 颖儿娇羞爆表'];
	var pArr = ['辣爸银幕成绩单&lt;&lt爸爸去哪儿?&gt;&gt;今晚又要来了,你看过这些爸爸们的电影了么?','于正最新清宫偶像电影作品,你还没看呢?','史泰龙说:"我和施瓦辛格两人在私下里反复研究,如何能让动作连贯,效果更显著,尤其在飞机上的枪战戏我们合作十分默契."','MV中刘青云,古天乐与张家辉时而并肩作战,时而针锋相对,甚至持枪互指,三兄弟恩仇难辨,电影的悬疑气氛不言而喻.','疑似轻度"露出"的杜淳直接让一脸纯萌的颖儿"惨遭惊吓"到爆表,一种唯美的浪漫喜剧感扑面而来,让人对影片剧情大感好奇和期待','辣爸银幕成绩单&lt;&lt爸爸去哪儿?&gt;&gt;今晚又要来了,你看过这些爸爸们的电影了么?','于正最新清宫偶像电影作品,你还没看呢?','史泰龙说:"我和施瓦辛格两人在私下里反复研究,如何能让动作连贯,效果更显著,尤其在飞机上的枪战戏我们合作十分默契."','MV中刘青云,古天乐与张家辉时而并肩作战,时而针锋相对,甚至持枪互指,三兄弟恩仇难辨,电影的悬疑气氛不言而喻.','疑似轻度"露出"的杜淳直接让一脸纯萌的颖儿"惨遭惊吓"到爆表,一种唯美的浪漫喜剧感扑面而来,让人对影片剧情大感好奇和期待'];

	//初始化布局,生成10个aLi
	createLi(0,9);

	//图片从左往右滑动
	/*
	 * 1.0:图片往右划,划到514*0的时候停止3s
	 * 1.1:图片从514*0往右划,划到514*1的时候停止3s
	 * 1.2:图片从514*1接着往右划,划到514*2的时候停止3s
	 * 1.3:图片从514*2接着往右划,划到514*3的时候停止3s
	 * 1.4:图片从514*3接着往右划,划到514*4的时候停止3s
	 *
	 */


	// oCon.onclick = function(){

		window.clearInterval(timer1);

		changeExp();

		//每隔3s执行一次右划函数,并将index+1;
		timer1 = window.setInterval(function(){

			goRight(index,index+1);

			index++;

			if(index == 20){
				window.clearInterval(timer1);
				index = 0;
				// oExp.style.bottom = "7px";
			}

			if(index > 5){
				removeLi();
			}

			changeExp();


		},3000)

	// }



	//更换说明
	function changeExp(){

		var arrIndex = Math.ceil(index % 5);
		//更换H3
		oH3.innerHTML = h3Arr[arrIndex];
		//更换P
		oP.innerHTML = pArr[arrIndex];


		var currentBot =window.parseInt(window.getComputedStyle(oExp,null).bottom.split("px")[0]);

		var speed = 10;

		timer3 = window.setInterval(function(){

			currentBot += speed;

			if(currentBot >= 7){
				currentBot = 7;
				window.setTimeout(function(){
					speed = -10;
				},2000);
			}

			if(currentBot <= -80){
				currentBot = -80;
				window.clearInterval(timer3);

			}

			oExp.style.bottom = currentBot +"px";

		},40);


	}


	//往右划
	function goRight(start,end){

		var currentPos = -514 * start;

		timer2 = window.setInterval(function(){

			currentPos += (-8);

			if(Math.abs(currentPos) >= 514*(end)){
				currentPos = -514*end;
				window.clearInterval(timer2);
			}
			oUl.style.left = currentPos + "px";

		},5);
	}



	//删除(start,end)个Li,并赋值Img.src及Left值
	function removeLi(){
		//获取第一个Li元素的当前Left值
		var currentLeft = window.parseInt(aLi[0].style.left);

		//计算一轮以后的Left值,为当前Left值+ 每一轮的Li数 * 轮数 * Li的宽度
		var futherLeft = currentLeft + 10 * 1 * 514;

		aLi[0].style.left = futherLeft + "px";

		oUl.appendChild(aLi[0]);
	}


	//生成(start,end)个Li,并赋值Img.src及Left值
	function createLi(start,end){
		for (var j = start, lenj = end - start + 1;  j< lenj; j++) {

			var oImg = document.createElement("img");

			var oLi = document.createElement("li");

			oImg.src = picArr[j];

			oLi.appendChild(oImg);

			oLi.style.left = 514*j + "px";

			oUl.appendChild(oLi);

		}

	}
}
