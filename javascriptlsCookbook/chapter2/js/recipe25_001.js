window.onload=function(){
	var searchString = "Now is the time, this is the time";
	var re = /t\w{2}e/g;
	var replacement = searchString.replace(re,"place");
	alert(replacement);
}
