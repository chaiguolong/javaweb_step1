var prefLineLength = 20;
var oldStr = "This is a string";

var diff = prefLineLength - oldStr.length;

var filler = '&nbsp;';

for (var i = 0; i < diff; i++) {
	oldStr = filler + oldStr;
}

  document.getElementById("result").innerHTML=oldStr;
