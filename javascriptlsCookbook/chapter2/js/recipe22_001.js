window.onload=function(){
	var cookbookString = new Array();

	cookbookString[0] = "Joe's Cooking Book";
	cookbookString[1] = "Sam's Cookbook";
	cookbookString[2] = "JavaScript CookBook";
	cookbookString[3] = "JavaScript cookbook";

	var pattern = /Cook.*Book/i;
	for (var i = 0, len = cookbookString.length; i < len; i++) {
		alert(cookbookString[i] + "		" + pattern.test(cookbookString[i],i));
		
	}

}
