function positionObject(obj){
	var rect = obj.getBoundingClientRect();
	return [rect.left,rect.top];
}


window.onload=function(){
	var tst = document.documentElement.getBoundingClientRect();
	var cont = "A";
	var cursor = document.getElementById("cursor");
	while(cont){
		cont = prompt("Where do you want to move the cursor block?","A");
		if(cont){
			cont=cont.toLowerCase();
			var elem = document.getElementById(cont);
			var pos = positionObject(elem);
			cursor.setAttribute("style","top: " + pos[1] + "px; left :" + pos[0] + "px");
		}
	}
}
