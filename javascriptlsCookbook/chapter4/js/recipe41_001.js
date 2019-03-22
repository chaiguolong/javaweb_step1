window.onload=function(){
	document.onclick=nextTest;
}

var globalCounter = 0;

function nextTest(){
	globalCounter++;
	alert('val is ' + globalCounter);
}
