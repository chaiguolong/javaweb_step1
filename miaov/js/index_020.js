window.onload = function(){
	var oUl = document.getElementsByClassName("list");

	var aLi1 = oUl[0].getElementsByTagName("li");

	var aLi2 = oUl[1].getElementsByTagName("li");

	var oDiv = document.getElementsByClassName("list2")[0];

	//准备图片数据
	var picArr = ['../images/020_001.png','../images/020_002.png','../images/020_003.png','../images/020_004.png']

	switchPic(aLi1,"onclick","#e7e7e7","#fff");
	switchPic(aLi2,"onmouseover","rgba(0,0,0,0.8)","#f05");

	function switchPic(aLi,event,colorbf,coloraf){
		for (var i = 0, len = aLi.length; i < len; i++) {
			aLi[i].index = i;
			aLi[i][event] = function(){
				oDiv.children[0].src = picArr[this.index];
				for (var k = 0, lenk = aLi.length; k < lenk; k++) {
					aLi[k].style.backgroundColor = colorbf;
				}
			this.style.background = coloraf;
			}
		}

	}

}
