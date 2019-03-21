window.onload = function(){
	var sentence = "This is one sentence. THis is a sentence with a list of items: cherries,oranges,apples,bananas.";
	var start = sentence.indexOf(":");
	var end = sentence.indexOf(".",start+1);

	var list = sentence.substring(start+1,end);

	alert(list);
}
