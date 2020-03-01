window.onload = function () {
	var oUl = document.getElementById('list');
	var aLi = oUl.getElementsByTagName('li');
	var oP = document.getElementsByTagName("p")[0];

	var count = 0;
	var totalPrice = 0;
	var maxPrice = 0;
	

	// fnCount ( aLi[0] );
	for ( var i=0; i<aLi.length; i++ ) {
		fnCount (aLi[i] );
	}
	
	function fnCount (li) {
		var aBtn = li.getElementsByTagName ('input');
		var oStrong = li.getElementsByTagName ('strong')[0];
		var oEm = li.getElementsByTagName ('em')[0];
		var oSpan = li.getElementsByTagName ('span')[0];
		var n = Number(oStrong.innerHTML);			// '0'
		var price = parseFloat(oEm.innerHTML);			// 12.5
		if(price > maxPrice){
			maxPrice = price;
		}

		
		aBtn[0].onclick = function () {
			if ( n > 0 ) {
				n--;
				count --;
				totalPrice -= price;
			}
			oStrong.innerHTML = n;
			oSpan.innerHTML = n*price + '元';

			oP.innerHTML = "商品合计共："+count+"件，共花费了："+totalPrice+"元<br />其中最贵的商品单价是："+maxPrice+"元";
		};
		aBtn[1].onclick = function () {
			n++;
			oStrong.innerHTML = n;
			oSpan.innerHTML = n*price + '元';

			count ++;
			totalPrice += price;
			oP.innerHTML = "商品合计共："+count+"件，共花费了："+totalPrice+"元<br />其中最贵的商品单价是："+maxPrice+"元";
		};
	}



};
