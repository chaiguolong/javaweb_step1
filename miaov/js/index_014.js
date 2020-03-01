window.onload = function(){

	var aH3 = document.getElementsByTagName("h3");

	var aUl = document.getElementsByTagName("ul");

	var oH3 = document.getElementsByClassName("hOpen");

	var aLi = document.getElementsByTagName("li");




	for (var i = 0, len = aH3.length; i < len; i++) {
		aH3[i].count = 0;
		aH3[i].index = i;

		aH3[i].onclick = function(){
			//如果当前元素点击为偶数,则显示,奇数则隐藏
			if(this.count % 2 == 0){
				//如果点击的元素和显示的元素不是同一个元素,那么显示的元素折叠隐藏,并且count+1,点击的元素显示
					if(typeof(oH3[0]) == "undefined"){
						aUl[this.index].style.display = "block";
						aH3[this.index].setAttribute("class","hOpen");
					}
					else if( oH3[0] != "undefined" && oH3[0].index != this.index){
						oH3[0].count++;
						aUl[oH3[0].index].style.display = "none";
						aH3[oH3[0].index].setAttribute("class","hClose");
						// 点击的元素显示
						aUl[this.index].style.display = "block";
						aH3[this.index].setAttribute("class","hOpen");
					}else{
						aUl[this.index].style.display = "block";
						aH3[this.index].setAttribute("class","hOpen");
					}
					
			}else{
				aUl[this.index].style.display = "none";
				aH3[this.index].setAttribute("class","hClose");
			}
			this.count++;

		}
	}


	for (var j = 0, len1 = aLi.length; j < len1; j++) {
		aLi[j].onclick = function(){
			for (var k = 0, len2 = aLi.length; k < len2; k++) {
				aLi[k].style.background = "#fff";
			}
			this.style.background = "#63f7ff";
		}
	}
	




}
