window.onload=function(){
	var oUl = document.getElementsByTagName("ul")[0];
	var aColor = ["red","yellow","blue","green","pink","red","yellow","blue","green","pink"]
	var oIn = document.getElementById("input");
	oIn.onclick = function(){
		createLi();
	}

	function createLi(){
		var tenLi = "";
		for (var i = 0, len = 100; i < len; i++) {
			var topNum = Math.floor(i/10)*60;
			var leftNum = i%10*60;
			tenLi += "<li style='background:"+aColor[i%(aColor.length -1)]+"; left:"+ leftNum+"px;top:"+ topNum +"px;'>"+i+"</li>";
		}
		oUl.innerHTML = tenLi;
	}

}
