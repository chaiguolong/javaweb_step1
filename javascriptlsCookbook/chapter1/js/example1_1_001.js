window.onload = function(){
	var keywordList = prompt("Enter keywords, separated by commas","");

	var arrayList = keywordList.split(",");

	var resultString = "";
	for (var i = 0, len = arrayList.length; i < len; i++) {
		resultString += "keyword: " + arrayList[i] + "<br />";
	}

	var blk = document.getElementById("result");
	blk.innerHTML = resultString;
}
