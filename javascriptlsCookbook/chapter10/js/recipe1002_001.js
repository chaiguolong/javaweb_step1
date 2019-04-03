function sumNumbers(numArray){
	var result = 0;

	if(numArray.length > 0){
		for (var i = 0, len = numArray.length; i < len; i++) {
			if(typeof numArray[i] == "number"){
				result += numArray[i];
			}else{
				result = NaN;
				break;
			}
		}
	}else{
		result = NaN;
	}
	return result;
}

window.onload=function(){
	var ary = new Array(1,15,"three",5,5);
	var res = sumNumbers(ary);
	if(isNaN(res)){
		alert("Encountered a bad array or array element");
	}
}
