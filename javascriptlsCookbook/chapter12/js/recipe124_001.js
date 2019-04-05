window.onload=function(){
	var div = document.getElementById("target");

	var paras = div.getElementsByTagName("p");

	var newPara = document.createElement("p");
	if(paras[3]){
		div.insertBefore(newPara,paras[3]);
	}else{
		div.appendChild(newPara);
	}

	newPara.innerHTML="This is the new paragraph";
}
