window.onload = function(){
	var oBut = document.getElementById("button");

	var oDiv = document.getElementById("div");


	//判断在数组中是否存在该数字,存在返回true,不然返回false
	function isRepeat(num,arr){
		for (var i = 0, len = arr.length; i < len; i++) {
			if(arr[i] == num){
				return true;
			}
		}
		return false;
	}


	//随机产生100个从0~1000之间不重复的整数
	oBut.onclick = function(){

		var numArr = [];

		var str = '';

		for (var i = 0, len = 100; i < len; i++) {

			var num = window.parseInt(Math.random()*1000);

			//判断在数组中是否重复,如果重复i--

			if(isRepeat(num,numArr)){
				i--;
				continue;
			}

			numArr.push(num);

		}

		str = numArr.join(" ");

		oDiv.innerHTML = str;
	}

}
