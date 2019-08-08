window.onload = function(){
	var aLi = document.getElementsByTagName("li");

	var oQX = document.getElementById("quanxuan");

	var oldColor = "";

	var isAllCheck = false;

	//鼠标划过,改变背景色
	for (var i = 0, len = aLi.length; i < len; i++) {
		aLi[i].onmouseover = function(){
			oldColor = this.style.background;
			this.style.background = "#efefef";
		}

		aLi[i].onmouseout = function(){
			this.style.background = oldColor;
		}
	}

	//全选,反选
	oQX.onclick = function(){
		if(isAllCheck == false){
			for (var i = 0, len = aLi.length; i < len; i++) {
				aLi[i].children[0].children[0].checked = true;
			}
			isAllCheck = true;
		}else if(isAllCheck == true){
			for (var j = 0, lenj = aLi.length; j < lenj; j++) {
				aLi[j].children[0].children[0].checked = false;
			}
			isAllCheck = false;
		}
	}

	//子Li取消选中,全选也取消
	for (var j = 0, lenj = aLi.length; j < lenj; j++) {
		//如果子Li有取消选中,那么全选也取消选中
		aLi[j].onclick = function(){
			if(this.children[0].children[0].checked == false){
				oQX.checked = false;
				isAllCheck = false;
			}
			isAll(aLi);
		}

	}

	//判断有没有全部选中,判断选中的input的数量或者长度
	function isAll(aLi){
		var num = 0;
		for (var i = 0, len = aLi.length; i < len; i++) {
			if(aLi[i].children[0].children[0].checked == true){
				num ++;
			}
		}
		if(num == 6){
			oQX.checked = true;
			isAllCheck = true;
		}
	}

}
