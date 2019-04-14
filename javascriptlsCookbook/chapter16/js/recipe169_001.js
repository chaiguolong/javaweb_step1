window.onload=function(){
	"use strict";

	var Test = {
		value1 : "one",
		value2 : function(){
			return this.value1;
		}
	};

	try{
		Object.seal(Test);

		Test.value2 = "two";

		Test.newProp = "value3";

		Object.defineProperties(Title,"category",{
			get: function(){
				return category;
			},
			set: function(value){
				category = value;
			},
			enumerable : true,
			configurable: true
		});
	}catch(e){
		alert(e);
	}
}
