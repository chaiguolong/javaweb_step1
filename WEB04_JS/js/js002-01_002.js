function checkAll(){
	//1.获取编号前面的复选框
	var checkAllEle = document.getElementById("checkAll");
	//2.对编号前面复选框的状态进行判断
	if(checkAllEle.checked == true){
		//3.获取下面所有的复选框
		var checkOnes = document.getElementsByName("checkOne");
		//4.对获取的所有复选框进行遍历
		for(var i=0;i<checkOnes.length;i++){
			checkOnes[i].checked = true;
		}

	}else{
		//6.获取下面所有的复选框
		var checkOnes = document.getElementsByName("checkOne");
		//7.对获取的所有复选框进行遍历
		for(var i=0;i<checkOnes.length;i++){
			checkOnes[i].checked = false;
		}
	}
}
