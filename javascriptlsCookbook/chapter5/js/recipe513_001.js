function removeChars(element,index,array){
	return (element !== "**");
}

var charSet = new Array("**","bb","cd","**","cc","**","dd","**");

var newArray = charSet.filter(removeChars);

alert(newArray);
