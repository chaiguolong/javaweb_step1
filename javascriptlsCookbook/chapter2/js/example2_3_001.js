window.onload=function(){
	var re = /\\d/;
	var pattern = "\\d{4}";
	var str = "I want 1111 to find 3334 certain 5343 things 8484";
	var re2 = new RegExp(pattern,"g");
	var str1 = str.replace(re2,"****");
	alert(str1);
	var pattern2 = pattern.replace(re,"\\D");
	var re3 = new RegExp(pattern2,"g");
	var str2 = str.replace(re3,"****");
	alert(str2);
}
