function getVals(){
	var elems = document.getElementById("picker").elements;
	var elemArray = new Object();
	for (var i = 0, len = elems.length; i < len; i++) {
		if(elems[i].type == "text"){
			elemArray[elems[i].id] = elems[i].value;
		}
	}
	checkVals(elemArray);
	return false;

}

function checkVals(elemArray){
	var str = "";
	for (var key in elemArray) {
		str +=key + "," + elemArray[key] + " ";
	}
	document.getElementById("result").innerHTML = str;
}
