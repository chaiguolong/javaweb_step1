window.onload=function(){
	var items = new Array('apple','orange','cherry','lime');
	var sep = "*";
	concatenateString(items,sep);

	alert(items);
	alert(sep);
}

function concatenateString(strings,separator){
	var result = "";
	for (var i = 0, len = strings.length; i < len; i++) {
		result += strings[i] + separator;
	}
	separator = result;

	strings[strings.length] = result;
}
