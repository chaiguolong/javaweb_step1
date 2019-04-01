var inprocess = false;

window.onload=function(){
	document.forms["picker"].onsubmit=validateSubmit;
	document.getElementById("refresh").onclick=startOver;
}

function validateSubmit(){
	if(inprocess){
		return;
	}
	inprocess=true;
	document.getElementById("submitbutton").disabled=true;

	document.getElementById("refresh").style.display="block";
	document.getElementById("message").innerHTML="<p>We're now processing your request. It can take up to one minute.</p>"

	return false;
}

function startOver(){
	inprocess = false;
	document.getElementById("submitbutton").disabled=false;
	document.getElementById("message").innerHTML="";
	document.getElementById("refresh").style.display="none";
}
