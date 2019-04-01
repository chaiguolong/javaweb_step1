window.onload=function(){
	document.forms[0].elements["intext"].disabled=true;
	document.forms[0].elements["intext2"].disabled=true;
	document.forms[0].elements["intext3"].disabled=true;

	var radios = document.forms[0].elements["group1"];
	for (var i = 0, len = radios.length; i < len; i++) {
		radios[i].onclick=radioClicked;
	}
}
function radioClicked(){
	switch(this.value){
		case "one":
			document.forms[0].elements["intext"].disabled=false;
			document.forms[0].elements["intext2"].disabled=true;
			document.forms[0].elements["intext3"].disabled=true;
			break;
		case "two":
			document.forms[0].elements["intext2"].disabled=false;
			document.forms[0].elements["intext3"].disabled=true;
			document.forms[0].elements["intext"].disabled=true;
			break;
		case "three":
			document.forms[0].elements["intext3"].disabled=false;
			document.forms[0].elements["intext"].disabled=true;
			document.forms[0].elements["intext2"].disabled=true;
			break;
	}
}
