window.onload=function(){
	document.onclick=ranNumber;
}

function ranNumber(){
	var randomNumber = Math.floor(Math.random() * 255);
	document.getElementById("num").innerHTML=randomNumber;
}
