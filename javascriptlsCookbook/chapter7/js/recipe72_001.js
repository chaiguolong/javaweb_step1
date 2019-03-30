window.onload=function(){
	document.onclick = processClick;
}

function processClick(evt){

	evt = evt || window.event;
	var x = 0; var y = 0;

	if(evt.pageX){
		x = evt.pageX;
		y = evt.pageY;
	}else if(evt.clientX){
		var offsetX = 0;
		var offsetY = 0;

		if(document.documentElement.scrollLeft){
			offsetX = document.documentElement.scrollLeft;
			offsetY = document.documentElement.scrollTop;
		}else if(document.body){
			offsetX = document.body.scrollLeft;
			offsetY = document.body.scrollTop;
		}

		x = evt.clientX + offsetX;
		y = evt.clientY + offsetY;
	}
	alert("you clicked at x=" + x + " y=" + y);
}
