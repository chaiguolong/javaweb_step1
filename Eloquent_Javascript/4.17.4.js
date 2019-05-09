console.log(deepEqual({name:"hello",age:19},{name:"world",age:19}));

function deepEqual(a,b){
	if(a === b){
		return true;
	}

	if(a==null || typeof a != "object" || b==null || typeof b != "object"){
		return false;
	}

	var keyA = Object.keys(a);
	var keyB = Object.keys(b);


	if(keyA.length == keyB.length){
		for (var i = 0, len1 = keyA.length -1; i < len1; i++) {
			if(deepEqual(keyA[i],keyB[i]) && deepEqual(a[keyA[i]],b[keyB[i]])){
				return true;
			}
		}
	}

	return false;

}

