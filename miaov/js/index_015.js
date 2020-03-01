window.onload = function(){
	var arr = [ '100px', 'abc'-6, [], -98765, 34, -2, 0, '300', , function(){alert(1);}, null, document, [], true, '200px'-30,'23.45元', 5, Number('abc'), function(){ alert(3); }, 'xyz'-90 ];
	// 1、找到arr里所有的数字：-98765, 34, -2, 0, 5
	// for (var i = 0, len = arr.length; i < len; i++) {
	// 	if(typeof(arr[i]) === "number" && !isNaN(arr[i])){
	// 		console.log(arr[i]);
	// 	}
	// }

	var numArray = [];

	var max = 0;

	// 2、找到可以转成数字的：'100px', -98765, 34, -2, 0, '300', '23.45元',  5 
	for (var i = 0, len = arr.length; i < len; i++) {
		if(arr[i] === 0 ||window.parseInt(arr[i]) || window.parseFloat(arr[i])){
			if(arr[i] === 0){
				numArray.push(0);
			}else {
				numArray.push(window.parseFloat(arr[i]) || window.parseInt(arr[i]));
			}
		}
	}

	
	// 3、把转成数字以后，最大值判断出来：300
	for (var j = 0, len1 = numArray.length; j < len1; j++) {
		if(j == 0){
			max = numArray[0];
		}
		if(numArray[j+1] > max){
			max = numArray[j+1];
		}
	}
	

	// 4、把 NaN 所在的位置找出来：1 14 17  19
	for (var k = 0, len3 = arr.length; k < len3; k++) {
		if(typeof(arr[k]) === "number" && isNaN(arr[k])){
			console.log(k);
		}
	}

}



/*
	1、找到arr里所有的数字：-98765, 34, -2, 0, 5
	2、找到可以转成数字的：'100px', -98765, 34, -2, 0, '300', '23.45元',  5 
	3、把转成数字以后，最大值判断出来：300
	4、把 NaN 所在的位置找出来：1 14 17  19
*/
