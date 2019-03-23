window.onload=function(){
	var mammals = new Array("cat","dog","human","whale","seal");
	var animalString = "";
	for (var i = 0, len = mammals.length; i < len; i++) {
		animalString += mammals[i] + " ";
	}
	alert(animalString);
}
