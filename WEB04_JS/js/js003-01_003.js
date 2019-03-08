//1.创建一个二维数组用于存储省份和城市
var cities = new Array(3);
cities[0] = new Array("武汉市","黄冈市","襄阳市","荆州市");
cities[1] = new Array("长沙市","郴州市","株洲市","岳阳市");
cities[2] = new Array("石家庄市","邯郸市","廊坊市","保定市");
cities[3] = new Array("郑州市","洛阳市","开封市","安阳市");

function changeCity(val){
	//7.获取第二个下拉列表
	var cityEle = document.getElementById("city");
	//9.清空第二个下拉列表的option内容
	cityEle.options.length = 0;
	//2.遍历二维数组中的省份
	for(var i=0;i<cities.length;i++){
		if(i==val){
			//3.遍历用户选择的省份下的城市
			for(var j=0;j<cities.length;j++){
				//4.创建城市的文本节点
				var textNode = document.createTextNode(cities[i][j]);
				//5.创建option元素节点
				var opEle = document.createElement("option");
				//6.将城市的文本节点添加到option元素节点
				opEle.appendChild(textNode);
				//8.将option元素节点添加到第二个下拉列表中去
				cityEle.appendChild(opEle);
			}
		}
	}

}
