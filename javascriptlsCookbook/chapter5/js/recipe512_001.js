function convertToHex(element,index,array){
	return element.toString(16);
}

var decArray = new Array(23,255,122,5,16,99);

var hexArray = decArray.map(convertToHex);

alert(hexArray);
