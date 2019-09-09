window.onload = function(){
	var oDiv = document.getElementById("container");

	var aDiv = oDiv.getElementsByTagName("div");

	var index = 0;

	var timer2 = null;

	var timer3 = null;


	for (var i = 0, len = aDiv.length; i < len; i++) {
		aDiv[i].style.left = 90*i + "px";
		aDiv[aDiv.length -1].style.top = "0px";
	}

	//1.将Div下落

	oDiv.onclick = function(){

		var pos = aDiv[aDiv.length -1].style.top;

		console.log(pos);

		this.style.pointerEvents = "none";

		if(pos == "400px"){
			timer2 = window.setInterval(function(){

				doMove(aDiv[index],"top",-15,0);

				index++;

				if(index == aDiv.length){
					index = 0;
					window.clearInterval(timer2);
				}

			},100);

		}else if(pos == "0px"){
			timer2 = window.setInterval(function(){

				doMove(aDiv[index],"top",15,400);

				index++;

				if(index == aDiv.length){
					index = 0;
					window.clearInterval(timer2);
				}

			},100);

		}

		time3 = window.setTimeout(function(){
			oDiv.style.pointerEvents = "auto";
		},1650);

	}


	function doMove(oDiv,dir,speed,target){
		oDiv.timer1 = window.setInterval(function(){

			var currentDir = window.parseInt(window.getComputedStyle(oDiv,null)[dir]) + speed;

			if(speed > 0 && currentDir >= target){
				currentDir = target;
				window.clearInterval(oDiv.timer1);
			}

			if(speed < 0 && currentDir <= target){
				currentDir = target;
				window.clearInterval(oDiv.timer1);
			}

			var nextDir = currentDir  + "px";

			oDiv.style[dir] = nextDir;

		},30);


	}
}
