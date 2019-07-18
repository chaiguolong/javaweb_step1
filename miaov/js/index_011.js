window.onload=function(){
	var oUl = document.getElementsByTagName("ul")[0];
	var aColor = ["red","yellow","blue","green","pink","red","yellow","blue","green","pink"]
	var oIn = document.getElementById("input");
	oIn.onclick = function(){
		createLi();
	}

	function createLi(){
		var tenLi = "";
		var count = 0;
		for (var i = 0, len = 5; i < len; i++) {
			var num = Math.floor(len/2);
			if(num >= i){
				count++;
			}else{
				count--;
			}
			var topNum = (count-1)*51;
			var leftNum = i*51;
			tenLi += "<li style='background:"+aColor[i%(aColor.length -1)]+"; left:"+ leftNum+"px;top:"+ topNum +"px;'>"+i+"</li>";
		}
		oUl.innerHTML = tenLi;
	}

}
