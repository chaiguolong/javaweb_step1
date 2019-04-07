window.onload=function(){
	document.getElementById("button1").onclick=function(){
		var msg = prompt("what do you want the alert to say?");
		addPopUp(msg);
	}
}

function addPopUp(txt){
	var msg = document.getElementById("msg");
	if(msg){
		document.body.removeChild(msg);
	}

	var txtNd = document.createTextNode(txt);
	msg = document.createElement("div");
	msg.setAttribute("role","alert");
	msg.setAttribute("id","msg");
	msg.setAttribute("class","alert");

	msg.appendChild(txtNd);
	document.body.appendChild(msg);
}
