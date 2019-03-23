var arrayLength = 3;

var multiArray = new Array(arrayLength);

for (var i = 0, len = multiArray.length; i < len; i++) {
	multiArray[i] = new Array(arrayLength);
}

multiArray[0][0] = "apple";
multiArray[0][1] = "banana";
multiArray[0][2] = "cherry";

multiArray[1][0] = 2;
multiArray[1][1] = 56;
multiArray[1][2] = 83;

multiArray[2][0] = ['test','again'];
multiArray[2][1] = ['Java','script'];
multiArray[2][2] = ['read','books'];

alert(multiArray);
alert(multiArray[2]);
alert(multiArray[2][2][0]);
