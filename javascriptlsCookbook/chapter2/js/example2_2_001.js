window.onload=function(){
	document.getElementById("searchSubmit").onclick=doSearch;
}

function doSearch(){

	var pattern = document.getElementById("pattern").value;
	var re = new RegExp(pattern,"g");

	var searchString = document.getElementById("incoming").value;

	var resultString = searchString.replace(re,"<span class='found'>$&</span>");

	document.getElementById("searchResult").innerHTML=resultString;

}
