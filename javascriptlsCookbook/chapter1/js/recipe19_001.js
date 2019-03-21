window.onload=function(){
	document.getElementById("preview").onclick=processText;
}

function processText(){
	var txtBox = document.getElementById("inputbox");
	var lines = txtBox.value.split("\n");

	var resultString = "<p>";
	for (var i = 0, len = lines.length; i < len; i++) {
		resultString += lines[i] + "<br />";
	}
	resultString += "</p>";

	var blk = document.getElementById("result");
	blk.innerHTML = resultString;
}
