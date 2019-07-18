window.onload=function(){
	var oUl = document.getElementsByTagName("ul")[0];
	var aColor = ["red","yellow","blue","green","pink","red","yellow","blue","green","pink"]
	var oIn = document.getElementById("input");
	oIn.onclick = function(){
		createLi();
	}

	function createLi(){
		var tenLi = "";
		for (var i = 0, len = 10; i < len; i++) {
			tenLi += "<li style='background:"+aColor[i]+"; left:"+ 60*i+"px;'>"+i+"</li>";
		}

		oUl.innerHTML = tenLi;
	}

}
