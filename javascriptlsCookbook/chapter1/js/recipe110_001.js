window.onload=function(){
	document.getElementById("preview").onclick=processText;
}

function processText(){
	var txtBox = document.getElementById("test");
	var lines = txtBox.value.split("\n");
	var resultString = "";

	for (var i = 0, len = lines.length; i < len; i++) {
		var strng = lines[i].trim();
		resultString += strng + "-";
	}

	document.getElementById("result").innerHTML=resultString;
}
