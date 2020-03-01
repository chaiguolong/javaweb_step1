window.onload = function(){

	var oUl_3 = document.getElementById("ul_3");

	var aLi_3 = oUl_3.getElementsByTagName("li");

	var oTop = document.getElementById("top");

	var aA = oTop.getElementsByTagName("a");

	var oMiddle = document.getElementById("middle");

	var aUl = oMiddle.getElementsByTagName("ul");


	focusLi(aLi_3);

	//切换选项卡
	for (var j = 0, lenj = aA.length; j < lenj; j++) {

		aA[j].onclick = function(){
			//将所有的UL隐藏
			for (var k = 0, lenk = aUl.length; k < lenk; k++) {
				aUl[k].style.display = "none";
			}
			//将所有选项卡的id置空
			for (var h = 0, lenh = aA.length; h < lenh; h++) {
				aA[h].removeAttribute("id");
			}

			this.setAttribute("id","active");
			var indexTop = this.getAttribute("class").split("_")[1];
			var showUl = document.getElementById("ul_"+indexTop);

			showUl.style.display = "block";
			var aLi = showUl.getElementsByTagName("li");

			focusLi(aLi);

		};
		
	}


	function focusLi(aLi){
		//聚焦模块
		for (var i = 0, len = aLi.length; i < len; i++) {
			aLi[i].onmouseover = function(){
				//获取数据
				var aThisA = this.children[0].childNodes;
				var indexNum = aThisA[0].innerHTML;
				var txt = aThisA[1].innerHTML;
				var arr = ['../images/018_focus.png','../images/018_jiemidangan.png','../images/018_jiemizhengping.png','../images/018_jingdian.png','../images/018_jishixilie.png','../images/018_laomao.png','../images/018_shijieshizui.png','../images/018_yanjie.png','../images/018_dangan.png','../images/018_dianying.png']

				this.setAttribute("class","focus");
				this.innerHTML = '<div id="append" class="stopSwitch"><a href="#" class="stopSwitch"><span id="indexIcon" class="stopSwitch">'+indexNum+'</span><img src="'+arr[indexNum-1]+'" id="suolue" class="stopSwitch"/><span id="content" class="stopSwitch">'+txt+'</span><img src="../images/018_bofang.png" id="bofang" class="stopSwitch"/></a> ';
				this.innerHTML += '</div>';
			};
			aLi[i].onmouseout = function(){
				//获取数据
				var aThisA = this.children[0].children[0].childNodes;
				var indexNum = aThisA[0].innerHTML;
				var txt = aThisA[2].innerHTML;

				this.removeAttribute("class","focus");
				//显示原有li内内容
				this.innerHTML = '<a href="#" class="stopSwitch"><span id="indexIcon" class="stopSwitch">'+indexNum+'</span><span class="stopSwitch">'+txt+'</span></a>';
			}
		}

	}




	
}
