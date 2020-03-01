window.onload=function(){

	var aContent = document.getElementsByClassName("content");

	var aEdit = document.getElementsByClassName("edit");

	var aSave = document.getElementsByClassName("save");

	var aCancel = document.getElementsByClassName("cancel");

	for (var i = 0, len = aContent.length; i < len; i++) {

		var oA = aContent[i].children[0].children[1];

		var oSave = aContent[i].children[1].children[1];

		var oCancel = aContent[i].children[1].children[2];


		aContent[i].index = i;

		edit(oA);

		save(oSave);

		cancel(oCancel);
	}

	//点击编辑
	function edit(oA){
		oA.onclick = function(){
			//获取数据
			//1.1全局索引
			var fullIndex = this.parentElement.parentElement.index;
			var txt1 = aContent[fullIndex].children[0].children[0].innerHTML;
			aContent[fullIndex].children[0].style.display = "none";

			aEdit[fullIndex].children[0].value = txt1;
			aEdit[fullIndex].style.display = "block";
		}

	}

	//编辑界面保存和取消
	//1.1保存
	function save(oSave){

		oSave.onclick = function(){
			var fullIndex = this.parentElement.parentElement.index;
			var saveTxt = aEdit[fullIndex].children[0].value;
			//隐藏弹出层
			aEdit[fullIndex].style.display = "none";
			aContent[fullIndex].children[0].children[0].innerHTML = saveTxt;
			aContent[fullIndex].children[0].style.display = "block";
		}
	}

	//1.2取消
	function cancel(oCancel){
		oCancel.onclick = function(){
			var fullIndex = this.parentElement.parentElement.index;
			aContent[fullIndex].children[1].style.display = "none";
			aContent[fullIndex].children[0].style.display = "block";
		}
	}



}
