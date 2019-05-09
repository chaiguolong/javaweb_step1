var twoArray = [[1,2,3],[4,5,6],7,8,9];

var reducer = function fall(fal,item){
	var finArray = fal.concat(item);
	return finArray;
};

var fallArray = twoArray.reduce(reducer,[]);

console.log(fallArray);
