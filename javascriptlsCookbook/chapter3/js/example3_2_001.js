var intervalId = null;
window.onload=function(){
	document.getElementById("redbox").onclick=stopStartElement;
}
function stopStartElement(){
	if(intervalId == null){
		var x = 100;
		intervalId=setInterval(function(){
			x += 5;
			var left = x + "px";
			document.getElementById("redbox").style.left = left;
		},100);
	}else{
		clearInterval(intervalId);
		intervalId = null;
	}
}
