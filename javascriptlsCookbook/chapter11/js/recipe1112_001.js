window.onload=function(){
	var elem = document.getElementById("elem");
	alert(elem.id);
	alert(elem.className);

	var index = elem.getAttribute("data-index");
	alert(index);

	var role = elem.getAttribute("role");
	alert(role);

	var field = document.getElementById("field");
	alert(field.checked);
	alert(field.value);
	alert(field.type);
}
