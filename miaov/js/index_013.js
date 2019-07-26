window.onload=function(){
	//获取元素
	var aLeft = document.getElementById("aLeft");
	var aRight = document.getElementById("aRight");
	var oImg01 = document.getElementById("img01");
	var oImg02 = document.getElementById("img02");
	var oP1 = document.getElementById("p01");
	var oP2 = document.getElementById("p02");
	var oSpan01 = document.getElementById("span01");
	var oSpan02 = document.getElementById("span02");
	var aTop01 = document.getElementById("aTop01");
	var aTop02 = document.getElementById("aTop02");

	//定义数组,将图片数据存入数组中
	var arrLeft = ['../images/013_011.png','../images/013_012.png','../images/013_013.png','../images/013_014.png'];
	var arrRight = ['../images/013_021.png','../images/013_022.png','../images/013_023.png'];

	//设置aLeft的indexLeft属性的默认值
	/*
	 * 1,2,3,0
	 * 0,1,2,3
	 *
	 */
	aLeft.indexLeft = 0;
	aRight.indexRight = 0;
	/* 1: 1-->2-->3-->0-->1-->2-->3-->0
	 *
	 */
	aLeft.onclick = function(){
		if(aLeft.indexLeft == arrLeft.length -1){
			aLeft.indexLeft = 0;
		}else{
			aLeft.indexLeft = aLeft.indexLeft + 1;
		}
		//1.2将arrLeft的路径赋值给img的src属性
		oImg01.src = arrLeft[this.indexLeft];
		oP1.innerHTML = "第一组第"+(this.indexLeft+1)+"张"
		oSpan01.innerHTML = ""+(this.indexLeft+1)+"/"+arrLeft.length;
	}
	aRight.onclick = function(){
		//1.1如果是循环,则将索引置为0,将循环开关关闭,如果不是循环,则正常+1
		if(aRight.indexRight == arrRight.length -1){
			aRight.indexRight = 0;
		}else{
			aRight.indexRight = aRight.indexRight + 1;
		}
		//1.2将arrRight的路径赋值给img的src属性
		oImg02.src = arrRight[this.indexRight];
		oP2.innerHTML = "第二组第"+(this.indexRight+1)+"张"
		oSpan02.innerHTML = ""+(this.indexRight+1)+"/"+arrRight.length;
	}

	//按组来对图片翻页

	//1.1上一组
	aTop01.onclick= function(){
		//1.1如果索引为0
		if(aLeft.indexLeft == 0){
			aLeft.indexLeft = arrLeft.length;
		}
		if(aRight.indexRight == 0){
			aRight.indexRight = arrRight.length;
		}
		//1.2如果索引不为0,则--
		aLeft.indexLeft = aLeft.indexLeft-1;
		oImg01.src = arrLeft[aLeft.indexLeft];
		oP1.innerHTML = "第一组第"+(aLeft.indexLeft + 1)+"张";
		oSpan01.innerHTML = ""+(aLeft.indexLeft+1)+"/"+arrLeft.length;

		aRight.indexRight = aRight.indexRight-1;
		oImg02.src = arrRight[aRight.indexRight];
		oP2.innerHTML = "第二组第"+(aRight.indexRight + 1)+"张";
		oSpan02.innerHTML = ""+(aRight.indexRight+1)+"/"+arrRight.length;
		console.log(aLeft.indexLeft);
	}

	//1.2下一组
	aTop02.onclick= function(){
		// console.log(arrLeft.length);
		//1.1如果索引为arrLeft.length
		if(aLeft.indexLeft == arrLeft.length-1){
			aLeft.indexLeft = -1;
		}
		if(aRight.indexRight == arrRight.length-1){
			aRight.indexRight = -1;
		}
		//1.2如果索引不为arrLeft.length,则++
		aLeft.indexLeft = aLeft.indexLeft+1;
		oImg01.src = arrLeft[aLeft.indexLeft];
		oP1.innerHTML = "第一组第"+(aLeft.indexLeft + 1)+"张";
		oSpan01.innerHTML = ""+(aLeft.indexLeft+1)+"/"+arrLeft.length;

		aRight.indexRight = aRight.indexRight+1;
		oImg02.src = arrRight[aRight.indexRight];
		oP2.innerHTML = "第二组第"+(aRight.indexRight + 1)+"张";
		oSpan02.innerHTML = ""+(aRight.indexRight+1)+"/"+arrRight.length;
		// console.log(aLeft.indexLeft);
	}

}
