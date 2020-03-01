window.onload = function(){
	var oBtn = document.getElementById("judge");

	var oTxt = document.getElementById("qqNum");


	oBtn.onclick = function(){
		var qqNum = oTxt.value;
		var firstNum = qqNum.split('');

		if(qqNum == ''){
			alert("输入不能为空!");
		}else if(!Number(qqNum)){
			alert("输入的不是数字");
		}else if(firstNum[0] == "0"){
			alert("不能有0在前面");
		}else if(qqNum.indexOf(".") > -1){
			alert("不能是小数");
		}else if(qqNum.length <= 5 || qqNum.length >= 10){
			alert("输入的数字必须在5位以上,10位以内");
		}
	}

}
