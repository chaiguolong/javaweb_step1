var origArray = new Array();
origArray[0] = new Array("one","two");
origArray[1] = new Array("three","four");
origArray[2] = new Array("five","six");
origArray[3] = new Array("seven","eight");

var newArray = origArray[0].concat(origArray[1],origArray[2],origArray[3]);
alert(newArray[5]);
alert(newArray);
