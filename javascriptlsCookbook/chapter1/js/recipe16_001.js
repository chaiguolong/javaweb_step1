window.onload = function(){
	if(((typeof unknownVariable != "undefined") && 
			(typeof unknownVariable.valueOf() == "string")) 
		&& (unknownVariable.length > 0)){
		alert("OK 1");
	}

	var unknownVariable;
	if(((typeof unknownVariable != "undefined") && 
		(typeof unknownVariable.valueOf() == "string")) &&
		(unknownVariable.length > 0)){
		alert("OK 2");
	}

	unknownVariable = "test";
	if(((typeof unknownVariable != "undefined") && 
		(typeof unknownVariable.valueOf() == "string")) &&
		(unknownVariable.length > 0)){
		alert("OK 3");
	}
}
