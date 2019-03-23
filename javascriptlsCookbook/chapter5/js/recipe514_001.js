var elemSet = new Array("**",123,"aaa","abc","-",46,"AAA");

function textValue(element,index,array){
	var textExp = /^[a-zA-Z]+$/;
	return textExp.test(element);
}

alert(elemSet.every(textValue));

var elemSet = new Array("**",123,"aaa","abc","-",46,"AAA");

alert(elemSet.some(textValue));
