function oldObject(param1){
	this.param1 = param1;
	this.getParam = function(){
		return this.param1;
	}
}

function newObject(param1,param2){
	this.param2 = param2;
	this.getParam2 = function(){
		return this.param2;
	}
	oldObject.apply(this,arguments);
	this.getAllParameters=function(){
		return this.getParam() + " " + this.getParam2();
	}
}




window.onload=function(){
	newObject.prototype = new oldObject();
	var obj = new newObject("value1","value2");

	alert(obj.getAllParameters());
}
