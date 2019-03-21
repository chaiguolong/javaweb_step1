document.getElementById("test").onclick=function(){
	var ssn = document.getElementById("pattern").value;
	var pattern = /^\d{3}-\d{2}-\d{4}$/;
	if(ssn.match(pattern)){
		alert("OK");
	}else{
		alert("Not OK");
	}
}
