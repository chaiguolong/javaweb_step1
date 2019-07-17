window.onload=function(){
	var oUl = document.getElementById("outer");
	var aLi = oUl.children;
	var oUl2 = document.getElementById("");

	for (var prop in aLi) {
		aLi[prop].onmouseover = function(){
			this.style.background = "red";
			this.getElementsByTagName("ul")[0].style.display = "block";
		}
		aLi[prop].onmouseout = function(){
			this.getElementsByTagName("ul")[0].style.display = "none";
			this.style.background = "black";
		}
	}
}
