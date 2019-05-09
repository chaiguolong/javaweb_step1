function reverseArray(arr){
	var reArray = [];
	for (var i = 0, len = arr.length; i < len; i++) {
		reArray.push(arr.pop());
	}
	return reArray;
}

function reverseArrayInPlace(arr){
	var temp;
	for (var i = 0, len = arr.length/2; i < len; i++) {
		temp = arr[i];
		arr[i] = arr[arr.length -1];
		arr[arr.length-1] = temp;
	}
	return arr;
}

// console.log(reverseArray([1,3,5,7,9]));
console.log(reverseArrayInPlace([1,3,5,7,9]));
