window.onload = function(){

	var aLi_con_menu_fold = document.getElementsByClassName("con_menu_fold");

	var aLi_con_menu = document.getElementsByClassName("con_menu");

	var aLi_menu = document.getElementsByClassName("menu");

	var oLi_title = document.getElementById("title");

	var aLi_title = oLi_title.getElementsByTagName("li");

	var oLi_content = document.getElementById("content");

	var aLi_content = oLi_content.getElementsByTagName("li");

	var oDiv_func = document.getElementById("func");

	var oClose = document.getElementById("close");

	var oSearch = document.getElementById("search");

	var oSearch_text = document.getElementById("search_text");

	var oReplace_text = document.getElementById("replace_text");

	var oCover = document.getElementById("cover");

	var oReplace = document.getElementById("replace");

	var oP_text = document.getElementById("p_text");

	var flag_li = true;

	closeTitle();
	showTitle();
	clickTitle();
	switchMenu();
	searchWord();
	replaceWord();

	//替换文本
	function replaceWord(){
		oReplace.onclick = function(){
			//获取字符串
			var replace_text = oReplace_text.value;
			var cover = oCover.value;
			//清除文本框的内容
			oReplace_text.value = '';
			oCover.value = '';
			//对输入文本进行过滤
			if(replace_text === ''){
				alert("请输入替换文本")
			}
			//获取整段文字
			var allText = oP_text.innerText;
			//处理成文本数组
			var textArr = allText.split(replace_text);
			if(textArr.length == 1){
				alert("对不起,没有找到您输入的["+replace_text +"]");
			}
			//加上span,和背景色
			var spanSearchText = "<span style='background:pink'>"+cover+"</span>"
			var finaText = textArr.join(spanSearchText);
			oP_text.innerHTML = finaText;

		}
	}

	//搜索
	function searchWord(){
		oSearch.onclick = function(){
			//获取字符串
			var search_text = oSearch_text.value;
			//清除文本框的内容
			oSearch_text.value = '';
			//对输入文本进行过滤
			if(search_text === ''){
				alert("请输入查找文本")
			}
			//获取整段文字
			var allText = oP_text.innerText;
			//处理成文本数组
			var textArr = allText.split(search_text);
			if(textArr.length == 1){
				alert("对不起,没有找到您输入的["+search_text +"]");
			}
			//加上span,和背景色
			var spanSearchText = "<span style='background:pink'>"+search_text+"</span>"
			var finaText = textArr.join(spanSearchText);
			//赋值给文字
			oP_text.innerHTML = finaText;
		}

	}



	//点击close按钮,隐藏功能菜单
	function closeTitle(){
		oClose.onclick = function(){
			oDiv_func.classList.add("hidden");
		}
	}

	//点击title切换功能菜单
	function clickTitle(){
		for (var k = 0, lenk = aLi_title.length; k < lenk; k++) {
			aLi_title[k].index = k;
			aLi_title[k].onclick = function(){
				switchTitle(this.index);
			}
		}
	}

	//切换title
	function switchTitle(index){
		//恢复默认状态
		for (var j = 0, lenj = aLi_title.length;  j< lenj; j++) {
			//取消选中
			aLi_title[j].children[0].classList.remove("select");
			//恢复黑色字体
			aLi_title[j].children[0].classList.add("title_a");
			//全部隐藏
			aLi_content[j].classList.add("hidden");
		}

		//显示点击的菜单内容
		aLi_title[index].children[0].classList.remove("title_a");
		aLi_title[index].children[0].classList.add("select");
		aLi_content[index].classList.remove("hidden");
		aLi_content[index].classList.add("show");

	}

	//点击菜单,显示内容
	function showTitle(){
		for (var i = 0, len = aLi_con_menu.length; i < len; i++) {

			aLi_con_menu[i].index = i;

			aLi_con_menu[i].onmouseover = function(){
				//点击之前先初始化默认的设置
				for (var i = 0, len = aLi_con_menu.length; i < len; i++) {
					aLi_con_menu[i].style.backgroundColor = "#c0c0c0";
					aLi_con_menu[i].children[0].style.color = "#000";
				}
				//高亮点击菜单颜色
				this.style.backgroundColor ="#e76308";
				this.children[0].style.color = "#fff";
				//显示方法的div
				oDiv_func.classList.remove("hidden");
				//显示点击的菜单内容
				// var index = this.index;
				// switchTitle(index);
			}

			aLi_con_menu[i].onclick = function(){
				//显示点击的菜单内容
				var index = this.index;
				switchTitle(index);
				//点击之后先初始化默认的设置
				for (var i = 0, len = aLi_con_menu.length; i < len; i++) {
					aLi_con_menu[i].style.backgroundColor = "#c0c0c0";
					aLi_con_menu[i].children[0].style.color = "#000";
					//隐藏子菜单
					aLi_con_menu[i].classList.add("hidden");
				}
				//将开关设置为true;
				flag_li = true;

			}
		}

	}

	//点击切换菜单
	function switchMenu(){
		aLi_con_menu_fold[0].onclick = function(){
			if(flag_li){
				for (var i = 0, len = aLi_con_menu.length; i < len; i++) {
					aLi_con_menu[i].classList.remove("hidden");
				}
				flag_li = false;
			}else{
				for (var i = 0, len = aLi_con_menu.length; i < len; i++) {
					aLi_con_menu[i].classList.add("hidden");
				}
				flag_li = true;
			}
		}

	}

}
