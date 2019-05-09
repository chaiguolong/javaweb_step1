var testArr = [1,2,3,4,5,6,7,8,9];

var testArr1 = [2,4,6,8];

var result = testArr1.every(function(item,index){
	if(item % 2 == 0){
		return true;
	}else{
		return false;
	}
});

console.log(result);
