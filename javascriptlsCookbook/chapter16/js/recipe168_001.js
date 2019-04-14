window.onload=function(){
	"use strict"

	var Test = {
		value1 : "one",
		value2 : function(){
			return this.value1;
		}
	};

	try{
		Object.preventExtensions(Test);

		Test.value3 = "test";
	}catch(e){
		alert(e);
	}

}
