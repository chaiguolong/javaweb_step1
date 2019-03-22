window.onload=function(){
	var x = 0;
	setInterval(moveElement,1000);

	function moveElement(){
		x += 10;
		var left = x + "px";
		document.getElementById("redbox").style.left = left;
	}
}

