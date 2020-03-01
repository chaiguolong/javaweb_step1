window.onload = function(){
	var oUl = document.getElementById("list");
	var aLi = oUl.getElementsByTagName("li");
	var oZhe = document.getElementById("zhezao");


	for (var i = 0, len = aLi.length; i < len; i++) {
		aLi[i].onmouseover = function(){
			var num = this.className.split("_")[1];
			if(num <= 6){
				oZhe.style.top = "115px";
				oZhe.style.left = 320 + 85*num +"px";
			}else if(num > 6 && num <=12){
				oZhe.style.left = 320 + 85*(num-6) +"px";
				oZhe.style.top = 115 + 90*Math.floor(num/6.1) +"px";
			}
			oZhe.style.display = "block";
		}
		aLi[i].onmouseout = function(){
			oZhe.style.display = "none";
		}
	}

}
