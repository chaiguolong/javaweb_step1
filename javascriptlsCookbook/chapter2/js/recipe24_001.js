window.onload=function(){
	var searchString = "Now is the time and this is the time and that is the time";

	var pattern = /t\w*e/g;

	var matchArray;

	var str = "";

	while((matchArray = pattern.exec(searchString)) != null){
		str+="at " + matchArray.index + " we found " + matchArray[0] + "<br />";
	}

	document.getElementById("results").innerHTML = str;
}
