window.onload=function(){

	var fibonacci = function(){
		var memo = [0,1];
		var fib = function(n){
			var result = memo[n];
			if(typeof result != "number"){
				result = fib(n-1) + fib(n-2);
				memo[n] = result;
			}
			return result;
		};
		return fib;
	}();

	var fib = function(n){
		return n < 2 ? n : fib(n-1) + fib(n-2);
	}

	console.time("non-memo");
	for (var i = 0, len = 10; i <= len; i++) {
		console.log(i + " " + fib(i));
	}

	console.timeEnd("non-memo");

	console.time("memo");
	for (var i = 0, len = 11; i < len; i++) {
		console.log(i + " " + fibonacci(i));
	}

	console.timeEnd("memo");
}
