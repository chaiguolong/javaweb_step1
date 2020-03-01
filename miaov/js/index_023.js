window.onload = function(){
	var oTop = document.getElementById("top");

	var oBottom = document.getElementById("bottom");

	var oPic = document.getElementById("pic");

	var timer1 = null;

	var mt = 22;

	oTop.onmousedown = function(){
		timer1 = window.setInterval(function(){
			if(mt > -348){
				mt-=2;
			}
			oPic.style.marginTop = mt+"px";
		},50);
	}

	oBottom.onmousedown = function(){
		timer2 = window.setInterval(function(){
			if(mt < 22){
				mt+=2;
			}
			oPic.style.marginTop = mt+"px";
		},50);
	}

	oTop.onmouseup = function(){
		window.clearInterval(timer1);
	}

	oBottom.onmouseup = function(){
		window.clearInterval(timer2);
	}

}
