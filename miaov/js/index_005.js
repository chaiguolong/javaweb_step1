window.onload = function(){
	//1.1获得top下所有a链接元素
	var oA = document.getElementById("top").getElementsByTagName("a");
	var oLi = document.getElementsByTagName("li");


	//切换oLi
	for (var prop in oA) {
		oA[prop].onclick = function(){
			var tab_id = this.getAttribute("id");
			//获取tab_id元素,更换tab_id背景颜色为黑色

			for (const prop of oA) {
				if(prop == this){
					this.style.background = "black";
				}else{
					prop.style.background = "#f75a09";
				}
			}

			var num = ""+tab_id.split("_")[1];
			var content_id = "content_" + num;
			var oUl = document.getElementById(content_id);
			var oUls = oUl.parentElement.getElementsByTagName("ul");

			for (const prop of oUls) {
				if(prop == oUl){
					prop.style.display = "block";
				}else{
					prop.style.display = "none";
				}
			}

		}
	}


	//1.2onmouseover
	function turnRed (){
		for (var prop in oLi) {
			oLi[prop].onmouseover = function(){
				this.style.background = "#fee";
			}
		}
	}

	//1.3onmouseout
	function turnWhite(){
		for (var prop in oLi) {
			oLi[prop].onmouseout = function(){
				this.style.background = "#fff";
			}
		}
	}

	//切换Li背景颜色
	turnRed();
	turnWhite();
}

