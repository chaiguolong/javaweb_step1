var arr = [1,2,3];

function arrayToList(arr){
	var list = null;
	for (var i = arr.length - 1; i >= 0; i--) {
		list = {value:arr[i],rest:list}
	}
	return list;
}

// console.log(arrayToList(arr));

// var list = {
// 	value:1,
// 	rest:{
// 		value:2,
// 		rest:{
// 			value:3,
// 			rest:null
// 		}
// 	}
// };


function listToArray(list){
	var arr = [];
	for(var node=list;node;node=node.rest){
		arr.push(node.value);
	}
	return arr;
}

// console.log(listToArray(list));

var list = {
	value:1,
	rest:{
		value:2,
		rest:{
			value:3,
			rest:null
		}
	}
};



function nth1(list,index){
	if(list.rest == null){
		return "undefinded";
	}
	var restObj;
	if(list.value == index){
		return list.rest;
	}else{
		return nth1(list.rest,index);
	}
}

console.log(nth1(list,1));

// console.log(nth(list,2));

function prepend(list,ele){
	var newList = {};
	newList.value = ele;
	newList.rest = list;
	return newList;
}

// console.log(list);
// console.log(prepend(list,0));


function nth(list,index){
	var ele;
	for(var node=list ; node ; node=node.rest){
		if(node.value == index){
			return node.rest;
		}
	}
	return undefinded;
}
