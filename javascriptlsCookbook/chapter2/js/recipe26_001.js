window.onload=function(){
	var name = "Abe Lincoln";
	var re = /^(\w+)\s(\w+)$/;
	var newname = name.replace(re,"$2,$1");
	alert(newname);
}
