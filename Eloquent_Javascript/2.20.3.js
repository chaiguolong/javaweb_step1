var result = "";
for (var i = 0, len = 8; i < len; i++) {
	for (var j = 0, len = 8; j < len; j++) {
		if((i+j)%2 == 0){
			result += "#";
		}else{
			result +=" ";
		}
	}
	result +="\n";
}
console.log(result);
