window.onload=function(){
	document.onclick=function(){
		try{
			var paras = document.querySelectorAll('div p:first-of-type');
			for (var i = 0, len = paras.length; i < len; i++) {
				paras[i].setAttribute("style","background-color:#ff0");
			}
		}catch(e){
			var divs = document.querySelectorAll("div");
			for(var j = 0; j < divs.length; j++){
				var ps = divs.item(j).getElementsByClassName("p");
				if(ps.length > 0){
					ps[0].setAttribute("style","background-color:#ff0");
				}
			}
		}
	}
}
