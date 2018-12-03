/*
 * 用于透明售房网展现楼盘表
 * 将VML的path转换成Raphael的path来渲染楼盘表，兼容浏览器
 * Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+
 * Author. linyingzhi 2013-03-20
 * update. linyingzhi 2013-03-27
 * 
 */
$(document).ready(function(){  
	//字体样式
	var _textstyle = {font: '12px 微软雅黑,宋体,Arial', fill: "black", "text-anchor": "start"};
	//声明容器大小
	var raphael = new Raphael('PropertyTable',3000,3000); 
	$('.raphael_box').each(function (){
		var house = $(this);//房屋对象
		//房屋路径转换
		var p = vmlpathToRaphaelPath($(house).attr('path'));
		//画矩形图
		var ele = raphael.path(p.path).attr('stroke', $(house).attr('strokecolor')).attr('fill', $(house).attr('fillcolor'));
		//判断是房屋
		if($(house).attr('types') == '0'){
			//查找房子属性
			//sid|houseid|internalid|propertyname|buildingname|unitname|houseno
			//|housestateid|housestatename|houseusage|builtuparea|declarationofroughprice
			//|totalprice|located|propertyid
			var h = $('#_h_' + $(house).attr('fwid')).attr('title');
			if( h == undefined || h == ""){
				return ;
			}
			else{
				var _a = h.split('|');//房屋属性
				//画标签内容
				var label = raphael.set();				
				label.push(raphael.text(60, 12, _a[3] + '-' + _a[4] + '-' + _a[5] + '-' + _a[6]).attr(_textstyle).attr('font-weight','bold'));
			    label.push(raphael.text(60, 35, '当前状态：' + _a[8]).attr(_textstyle));
			    label.push(raphael.text(60, 55, '房屋用途：' + _a[9]).attr(_textstyle));
			    label.push(raphael.text(60, 75, '建筑面积：' + _a[10] + '㎡').attr(_textstyle));
			    //if(_a[0] == '330191'){//临安站不显示
			    //	label.push(raphael.text(60, 95, '毛坯单价：暂无资料').attr(_textstyle));
			    //	label.push(raphael.text(60, 115, '总　　价：暂无资料').attr(_textstyle));
			    //}
			    //else {
			    	label.push(raphael.text(60, 95, '毛坯单价：' + _a[11] + '元/㎡').attr(_textstyle));
			    	label.push(raphael.text(60, 115, '总　　价：' + _a[12] + '元').attr(_textstyle));
			    //}
			    label.push(raphael.text(60, 135, '房屋坐落：' + _a[13]).attr(_textstyle));
			    label.hide();
			    //标签容器
				var frame = raphael.popup(p.centerX+p.width/2, p.centerY, label, "right").attr({fill: "#ffffe1", stroke: "#ffcc99", "stroke-width": 2, "fill-opacity": .9}).hide();
				//填充颜色并邦事件
				ele.attr('fill', showFillColor(_a[7])).attr('cursor', 'pointer').mouseover(function (){
					frame.toFront().show();
					label.toFront().show();
				}).mouseout(function (){
					frame.hide();
					label.hide();
				}).click(function (){
					showHouse(_a);
				});
				//画文字并邦事件
				var text = $(house).attr('title');	
				if(text.length*12 >= p.width){//文字超过容器宽度
					var _text = '';
					//每行可以写几个字
					var r =  parseInt(p.width/12);
					for(var i = 0, _col = 1; i < text.length && _col <= p.height/12; i++){
						_text += text.charAt(i);
						if((i+1)%r == 0){
							_text += '\n';//超过容纳字数换行
							_col ++;
						}
					}
					text = _text;
				}
				raphael.text(p.centerX, p.centerY, text).attr({'font-size':12, 'cursor': 'pointer'}).mouseover(function (){
					frame.toFront().show();
					label.toFront().show();
				}).mouseout(function (){
					frame.hide();
					label.hide();
				}).click(function (){
					showHouse(_a);
				});
			}
		}
		else if($(house).attr('types') == '1' || $(house).attr('types') == '2'){//楼层或者单元
			raphael.text(p.centerX, p.centerY, $(house).attr('title')).attr({'font-size':12});
		}
		else {
			//单元
			if($(house).attr('types') == '3' && $(house).attr('title') == '单元'){
				raphael.text(75, 15, $(house).attr('title')).attr({'font-size':12});
			}
			//楼层
			if((house).attr('types') == '3' && $(house).attr('title') == '楼层'){
				raphael.text(20, 35, $(house).attr('title')).attr({'font-size':12});
			}
		}
	});
	//踏雪无痕，哈哈
	$('._h_,.raphael_box').remove();
});

//显示房屋
function showHouse(_a){
	window.open('/newhouse/property_house_' + _a[0] + '_' + _a[14] + '_' + _a[1] +'.htm');
}

//讲VML路径转成Raphael路径，目前支持线段类型
function vmlpathToRaphaelPath(_path){
	var _returnObj = new Object();
	//去VML格式化完成路径
	var _format = _path.replace('m','').replace('l',',').replace('ex','');
	//坐标数组
	var _array = _format.split(',');
	//计算出Raphael路径
	var _rpath = 'M ';//moveTo
	for(var i in _array){
		_rpath += _array[i];
		if(i%2 != 0 && i != _array.length-1){
			_rpath += ' L';//lineTo
		}
		if(i%2 == 0){
			_rpath += ',';
		}
	}
	_rpath += ' z';//end
	_returnObj.path = _rpath;
	//坐标数组
	_returnObj.array = _array;
	//起始点X,Y
	_returnObj.startX = _array[0];
	_returnObj.startY = _array[1];
	//宽与高,矩形计算宽高
	if(_array.length >= 10){
		_returnObj.width = findWidth(_array);
		_returnObj.height = findHeight(_array);
		//中心点位置，用于填充文字
		_returnObj.centerX = parseInt(_array[0]) + parseInt(_returnObj.width/2);
		_returnObj.centerY = parseInt(_array[1]) + parseInt(_returnObj.height/2);
	}
	return _returnObj;
}

//计算矩形宽度
function findWidth(array){
	var _min = parseInt(array[0]), _max = parseInt(array[0]);
	for(var i in array){
		if(i%2==0){
			if(_min > parseInt(array[i])){
				_min = array[i];
			}
			if(_max < parseInt(array[i])){
				_max = parseInt(array[i]);
			}
		}
	}
	return _max-_min;
}

//计算矩形高度
function findHeight(array){
	var _min = parseInt(array[1]), _max = parseInt(array[1]);
	for(var i in array){
		if(i%2!=0){
			if(_min > parseInt(array[i])){
				_min = parseInt(array[i]);
			}
			if(_max < parseInt(array[i])){
				_max = parseInt(array[i]);
			}
		}
	}
	return _max-_min;
}

//获取填充颜色
function showFillColor(_sid){
	if(_sid == '0' || _sid == '4'){
		return "#FE0000";
	}
	else if(_sid == '1'){
		return "#019934";
	}
	else if(_sid == '2'){
		return "#FF9934";
	}
	else if(_sid == '3'){
		return "#FFFF01";
	}
	else if(_sid == '5'){
		return "#FFFFFF";
	}
	else if(_sid == '7'){
		return "#3377FF";
	}
	else if(_sid == '8'){
		return "#FC537C";
	}
	else {
		return "#FFFFFF";
	}
}
