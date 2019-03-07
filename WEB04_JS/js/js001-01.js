window.onload = function(){
	//1.获取表格
	var tblEle = document.getElementById("tbl");
	//2.获取表格中tbody里面的行数(长度)
	var len = tblEle.tBodies[0].rows.length;
	//alert(len);
	//3.对tbody里面的行进行遍历
	for(var i=0;i<len;i++){
		if(i%2==0){
			//4.对偶数行设置背景颜色
			tblEle.tBodies[0].rows[i].style.backgroundColor="pink";
		}else{
			//5.对奇数行设置背景颜色
			tblEle.tBodies[0].rows[i].style.backgroundColor="gold";
		}
	}
}
