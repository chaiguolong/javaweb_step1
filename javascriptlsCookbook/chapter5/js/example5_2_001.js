var charSets = new Array("ab","bb","cd","ab","cc","ab","dd","ab");

while(charSets.indexOf("ab") != -1){
	charSets.splice(charSets.indexOf("ab"),1,"**");
}

alert(charSets);

while(charSets.indexOf("**") != -1){
	charSets.splice(charSets.indexOf("**"),1);
}

alert(charSets);
