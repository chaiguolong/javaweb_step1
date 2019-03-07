function changeColor(id,flag){
	if(flag=="over"){
		document.getElementById(id).style.backgroundColor="red";
	}else if(flag=="out"){
		document.getElementById(id).style.backgroundColor="white";
	}
}
