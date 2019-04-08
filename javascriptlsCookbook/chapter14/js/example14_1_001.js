window.onload=function(){
	document.getElementById("thirdfield").onchange=validateField;
	document.getElementById("firstfield").onblur=mandatoryField;
	document.getElementById("testform").onsubmit=finalCheck;
}

function removeAlert(){
	var msg = document.getElementById("msg");
	if(msg){
		document.body.removeChild(msg);
	}
}

function resetField(elem){
	elem.parentNode.setAttribute("style","background-color:#ffffff");
	var valid = elem.getAttribute("aria-invalid");
	if(valid){
		elem.removeAttribute("aria-invalid");
	}
}

function badField(elem){
	elem.parentNode.setAttribute("style","background-color:#ffeeee");
	elem.setAttribute("aria-invalid","true");
}

function generateAlert(txt){
	var txtNd = document.createTextNode(txt);
	msg = document.createElement("div");
	msg.setAttribute("role","alert");
	msg.setAttribute("id","msg");
	msg.setAttribute("class","alert");

	msg.appendChild(txtNd);
	document.body.appendChild(msg);
}

function validateField(){
	removeAlert();

	if(!isNaN(parseFloat(this.value))){
		resetField(this);
	}else{
		badField(this);
		generateAlert("You entered an invalid value in Third Field. Only numeric values such as 105 or 3.54 are allowed");
	}
}

function mandatoryField(){
	removeAlert();

	if(this.value.length > 0){
		resetField(this);
	}else{
		badField(this);
		generateAlert("You must enter a value into First Field");
	}
}

function finalCheck(){
	removeAlert();

	var fields = document.querySelectorAll("[aria-invalid='true']");
	if(fields.length > 0){
		generateAlert("You have incorrect fields entries that must be fixed before you can submit this form");
		return false;
	}
}
