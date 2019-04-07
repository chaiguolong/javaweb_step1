window.onload=function(){
	document.getElementById("button1").onclick=hideshow;
	document.getElementById("msg").setAttribute("aria-hidden","true");
}

function hideshow(){
	var msg = document.getElementById("msg");
	var hidden = msg.getAttribute("aria-hidden");
	if(hidden == "true"){
		msg.setAttribute("aria-hidden","false");
	}else{
		msg.setAttribute("aria-hidden","true");
	}
}
