function countBs(str){
	var count = 0;
	for (var i = 0, len = str.length; i < len; i++) {
		if("B" == str.charAt(i)){
			count = count + 1;
		}
	}
	return count;
}

function countChar(str,chr){
	var count = 0;
	for (var i = 0, len = str.length; i < len; i++) {
		if(chr == str.charAt(i)){
			count = count + 1;
		}
	}
	return count;
}

// console.log(countBs("BloB"));
console.log(countChar("close door","o"));
