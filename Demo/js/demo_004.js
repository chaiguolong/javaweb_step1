window.onload = function(){
	var oA = document.getElementsByTagName("a");
	for (var i in oA) {
		oA[i].onmouseover = function(){
			this.setAttribute("class","over");
		}
		oA[i].onmouseout = function(){
			this.setAttribute("class","out");
		}
	}
}
