var firstDate;
window.onload=startTimer;

function startTimer(){
	firstDate = new Date();
	document.getElementById("date").onclick=doEvent;
}

function doEvent(){
	var secondDate = new Date();
	alert((secondDate - firstDate) / 1000);
}

