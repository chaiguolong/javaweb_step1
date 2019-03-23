var origArray = new Array(4);
origArray[0] = new Array("one","two");
origArray[1] = new Array("three","four");
origArray[2] = new Array("five","six");
origArray[3] = new Array("seven","eight");

var newArray = origArray.slice(1,3);
alert(newArray);

origArray[1][0] = "octopus";

alert(newArray);

newArray[1][1] = "kitten";

alert(origArray);
