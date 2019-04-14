if(!Function.bind){
	Function.prototype.bind = function(scope){
		var _function = this;

		return function(){
			return _function.apply(scope,arguments);
		}
	}
}

window.onload=function(){
	var theCounter = new Counter('item',10,0);
	theCounter.countDown();
}

function Counter(id,start,finish){
	this.count = this.start = start;
	this.finish = finish;
	this.id = id;
	this.countDown = function(){
		if(this.count == this.finish){
			this.countDown = null;
			return;
		}
		document.getElementById(this.id).innerHTML = this.count--;
		setTimeout(this.countDown.bind(this),1000);
	};
}
