var inprocess = false;

window.onload=function(){
	document.getElementById("hidden_elements").style.display="none";

	var radios = document.forms[0].elements["group1"];
	for (var i = 0, len = radios.length; i < len; i++) {
		radios[i].onclick=radioClicked;
	}
}

function radioClicked(){
	if(this.value == "two"){
		document.getElementById("hidden_elements").style.display="block";
	}else{
		document.getElementById("hidden_elements").style.display="none";
	}
}
