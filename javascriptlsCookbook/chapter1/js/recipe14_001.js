window.onload = function(){
	var testValue = "This is the Cookbook's test string";
	var subValue = "Cookbook";

	var iValue = testValue.indexOf(subValue);

	if(iValue != -1){
		alert(iValue);
	}
}
