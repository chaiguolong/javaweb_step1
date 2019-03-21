window.onload=function(){
	document.getElementById("searchSubmit").onclick=doSearch;
}

function doSearch(){
	var pattern = document.getElementById("pattern").value;
	var re = new RegExp(pattern,"g");

	var searchString = document.getElementById("incoming").value;

	var matchArray;
	var resultString = "<pre>";
	var first=0; var last = 0;

	while((matchArray = re.exec(searchString)) != null){
		last = matchArray.index;
		resultString += searchString.substring(first,last);

		resultString += "<span class='found'>" + matchArray[0] + "</span>";
		first = re.lastIndex;
	}

	resultString += searchString.substring(first,searchString.length);
	resultString += "</pre>";

	document.getElementById("searchResult").innerHTML = resultString;
}
