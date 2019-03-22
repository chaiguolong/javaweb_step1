window.onload=function(){
	document.onclick = ranNumber;
}

function randomVal(val){
	return Math.floor(Math.random() * val);
}

function randomColor(){
	//get red
	var r = randomVal(255).toString(16);
	if(r.length < 2) r = "0"+r;

	//get green
	var g = randomVal(255).toString(16);
	if(g.length < 2) g = "0"+g;

	//get blue
	var b = randomVal(255).toString(16);
	if(b.length <2) b = "0"+b;

	return "#"+r+g+b;
}

function ranNumber(){
	var hex = randomColor();
	document.getElementById("num").style.backgroundColor=hex;
}
