window.onload = function(){
	//获取元素
	var aLi_1 = document.getElementsByClassName("li_1");

	var aList2 = document.getElementsByClassName("list2");

	var timer1 = null;

	//选中子Li,加下划线,离开取消下划线
	for (var j = 0, lenj = aList2.length; j < lenj; j++) {

		var aA = aList2[j].getElementsByTagName("a");

		for (var k = 0, lenk = aA.length; k < lenk; k++) {
			aA[k].onmouseover = function(){
				this.style.textDecoration = "underline";
			}

			aA[k].onmouseout = function(){
				this.style.textDecoration = "none";
			}
		}
	}

	//移入标题Li,选中标题,移出标题Li,延迟2秒取消选中
	for (var i = 0, len = aLi_1.length; i < len; i++) {

		//移入鼠标
		aLi_1[i].onmouseover = function(){
			window.clearTimeout(timer1);
			// //先将之前别的样式复位
			for (var i = 0, len = aLi_1.length; i < len; i++) {
				aLi_1[i].children[0].classList.remove("focus");
				aLi_1[i].children[2].classList.remove("active");

			}
			this.children[0].classList.add("focus");
			this.children[2].classList.add("active");

		}

		//移出鼠标
		aLi_1[i].onmouseout = function(){
			window.clearTimeout(timer1);
			var that = this;
			timer1 = window.setTimeout(function(){
			// that.children[0].classList.remove("focus");
			that.children[2].classList.remove("active");
			},1000);
		}

	}
}
