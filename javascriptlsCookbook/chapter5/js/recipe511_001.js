var charSets = new Array("ab","bb","cd","ab","cc","ab","dd","ab");

function replaceElement(element,index,array){
	if(element == "ab"){
		array[index] = "**";
	}
}

charSets.forEach(replaceElement);
alert(charSets);
