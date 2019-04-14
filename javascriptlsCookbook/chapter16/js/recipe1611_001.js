window.onload=function(){

	var jscbObject = {
		getElem : function(identifier){
			return document.getElementById(identifier);
		},

		stripslashes : function(str){
			return str.replace(/\\/g,'');
		},

		removeAngleBrackets: function(str){
			return str.replace(/\\/g,'');
		}
	};

	var incoming = jscbObject.getElem("incoming");
	var content = incoming.innerHTML;

	var result = jscbObject.stripslashes(content);
	result = jscbObject.removeAngleBrackets(result);

	jscbObject.getElem("result").innerHTML=result;
}
