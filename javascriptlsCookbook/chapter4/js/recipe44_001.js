window.onload=function(){
	document.onclick=ranNumber;
}

function  randomVal(val){
	return Math.floor(Math.random() * val);
}

function randomColor(){
	return "rgb("+randomVal(255)+","+randomVal(255)+","+randomVal(255)+")";
}

function ranNumber(){
	var rgb = randomColor();
	document.getElementById("num").setAttribute("style","background-color: " + rgb);
}
