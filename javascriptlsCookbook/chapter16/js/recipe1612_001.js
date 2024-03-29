Function.prototype.bind = function(scope){
	var _function = this;

	return function(){
		return _function.apply(scope,arguments);
	}
}


window.onload=function(){
	window.name = "window";

	var newObject = {
		name: "object",
		sayGreeting: function(){
			alert("Now this is easy, " + this.name);
			nestedGreeting = function(greeting){
				alert(greeting + " " + this.name);
			}.bind(this);

			nestedGreeting("hello");
		}
	};

	newObject.sayGreeting("hello");


}
