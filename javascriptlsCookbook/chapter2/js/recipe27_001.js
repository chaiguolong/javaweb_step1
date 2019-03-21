window.onload=function(){
	var testString = "   this is the string    ";
	alert("before:" + testString);

	testString = testString.replace(/\s+/,"");

	testString = testString.replace(/\s+$/,"");

	alert("after:" + testString);
}
