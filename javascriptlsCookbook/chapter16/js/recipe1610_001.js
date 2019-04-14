window.onload=function(){
	"use strict";
	var Test = {
		value1 : "one",
		value2 : function(){
			return this.value1;
		}
	}

	try{
		Object.freeze(Test);

		Test.value2 = "two";

		Test.newProperty = "value";

		Object.defineProperties(Title,"category",{
			get: function(){return category;},
			set: function(value){category = value;},
			enumerble:true,
			configurable:true
		});
	}catch(e){
		alert(e);
	}
}
