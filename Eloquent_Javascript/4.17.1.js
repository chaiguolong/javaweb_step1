function range(start,end,step){
	var arr = [];
	if(step == "undefind"){
		step = 1;
	}
	for (var i = start, len = end; start <= end ? i <= end : i >= end; i+=step) {
		arr.push(i);
	}
	return arr;
}

function sum(arr){
	var sum = 0;
	for (var i = 0, len = arr.length; i < len; i++) {
		sum += arr[i];
	}

	return sum;
}

// console.log(range(5,2,-1));
console.log(range(0,10,2));
// console.log(sum(range(5,2,-1)));
console.log(sum(range(0,10,2)));
