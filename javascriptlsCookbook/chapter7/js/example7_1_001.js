window.onload=function(){
	document.onclick=processClick;
}

function processClick(evt){
	evt = evt || window.event;
	var x = 0; var y = 0;
	if(evt.pageX){
		x = evt.pageX;
		y = evt.pageY;
	}else if(evt.clintX){
		var offsetX = 0;
		var offsetY = 0;
		if(document.documentElement.scrollLeft){
			offsetX = document.documentElement.scrollLeft;
			offsetY = document.documentElement.scrollTop;
		}else if(document.body){
			offsetX = document.body.scrollLeft;
			offsetY = document.body.scrollTop;
		}

		x = evt.clintX + offsetX;
		y = evt.clintY + offsetY;
	}

	var style = "left: " + x + "px; top: " + y +"px";
	var box = document.getElementById("info");
	box.setAttribute("style",style);
}
